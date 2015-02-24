zul.googlecharts.GoogleChart = zk.$extends(zk.Widget, {

        _chartData: '',
        _chartOptions: '',

        $define: {
            chartData: [
                function (data) {
                    return data; // TODO this shouldn't be necessary!?
                },
                function () {
                    // TODO if options exists, redraw
                    if (this.desktop) this.rerender();
                }
            ],
            chartOptions: [
                function (options) {
                    return options; // TODO this shouldn't be necessary!?
                },
                function () {
                    // TODO if data exists, redraw
                    if (this.desktop) this.rerender();
                }
            ]
        },
        $init: function () {
            this.$supers(zul.googlecharts.GoogleChart, '$init', arguments);
            if (!zul.googlecharts.GoogleChart.googleLoaded && !zul.googlecharts.GoogleChart.googleLoading) {
                google.load('visualization', '1', {
                    'packages': ['corechart', 'timeline'],
                    'callback': zul.googlecharts.GoogleChart._onLoad
                });
                zul.googlecharts.GoogleChart.googleLoading = true;
            }
        },

        // protected //

        drawChart_: function (chart) {
            var widget = this;
            google.visualization.events.addListener(chart, 'error', function (err) {
                widget.fire('onError', err);
            });
            google.visualization.events.addListener(chart, 'ready', function () {
                widget.fire('onReady');
            });
            google.visualization.events.addListener(chart, 'onmouseover', function (evt) {
                widget.fire('onMouseOverInternal', evt);
            });
            google.visualization.events.addListener(chart, 'onmouseout', function (evt) {
                widget.fire('onMouseOutInternal', evt);
            });
            google.visualization.events.addListener(chart, 'select', function () {
                widget.fire('onSelectInternal', chart.getSelection());
            });
            var data = new google.visualization.DataTable(this._chartData);
            chart.draw(data, this._chartOptions);
        },
        container_: function () {
            return document.getElementById(this.uuid);
        }
    },
    {
        googleLoading: false,
        googleLoaded: false,

        addOnLoadCallback: function (f) {
            zul.googlecharts.GoogleChart._onLoadCallbacks.push(f);
        },

        _onLoadCallbacks: [],

        _onLoad: function () {
            zul.googlecharts.GoogleChart.googleLoading = false;
            zul.googlecharts.GoogleChart.googleLoaded = true;
            var l = zul.googlecharts.GoogleChart._onLoadCallbacks.length;
            for (var i = 0; i < l; i++) {
                var f = zul.googlecharts.GoogleChart._onLoadCallbacks[i];
                f();
            }
        }

    });