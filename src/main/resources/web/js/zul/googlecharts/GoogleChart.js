zul.googlecharts.GoogleChart = zk.$extends(zk.Widget, {

        _chartData: '',
        _chartOptions: '',

        $define: {
            chartData: [
                function (data) {
                    return data; // TODO this shouldn't be necessary!?
                },
                function () {
                    console.log('Setting data: ' + this._chartData);
                    // TODO if options exists, redraw
                    if (this.desktop) this.rerender();
                }
            ],
            chartOptions: [
                function (options) {
                    return options; // TODO this shouldn't be necessary!?
                },
                function () {
                    console.log('Setting options: ' + JSON.stringify(this._chartOptions));
                    // TODO if data exists, redraw
                    if (this.desktop) this.rerender();
                }
            ]
        },

        // protected //
        drawChart_: function (chart) {
            var data = new google.visualization.DataTable(this._chartData);
            chart.draw(data, this._chartOptions);
        },
        container_: function () {
            return document.getElementById(this.uuid);
        },
        bind_: function () {
            console.log('Binding GoogleChart');
            console.log('googleLoaded=' + zul.googlecharts.GoogleChart.googleLoaded);
            this.$supers(zul.googlecharts.GoogleChart, 'bind_', arguments);
        },
        unbind_: function () {
            this.$supers(zul.googlecharts.BarChart, 'unbind_', arguments);
        }

    },
    {
        googleLoaded: false,

        addOnLoadCallback: function (f) {
            zul.googlecharts.GoogleChart._onLoadCallbacks.push(f);
        },

        _onLoadCallbacks: [],
        _onLoad: function () {
            zul.googlecharts.GoogleChart.googleLoaded = true;
            console.log('Google loaded!');
            console.log('googleLoaded=' + zul.googlecharts.GoogleChart.googleLoaded);
            var l = zul.googlecharts.GoogleChart._onLoadCallbacks.length;
            console.log('Executing ' + l + ' queued callbacks..');
            for (var i = 0; i < l; i++) {
                var f = zul.googlecharts.GoogleChart._onLoadCallbacks[i];
                console.log('Executing ' + f);
                f();
            }
        }

    });
// Register a callback listener with the Google APIs, shared by all Google Chart widgets
google.setOnLoadCallback(zul.googlecharts.GoogleChart._onLoad);
