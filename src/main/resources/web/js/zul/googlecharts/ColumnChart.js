zul.googlecharts.ColumnChart = zk.$extends(zk.Widget, {

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
                console.log('Setting options: ' + this._chartOptions);
                // TODO if data exists, redraw
                if (this.desktop) this.rerender();
            }
        ]
    },

    // protected //

    doDrawChart_: function () {
        console.log("Drawing " + this.getMold() + " column chart..");
        console.log(this._chartData);
        console.log(this._chartOptions);
        console.log('Rendering column chart into ' + this.uuid);
        // Instantiate and draw our chart, passing in some options.
        var data = new google.visualization.DataTable(this._chartData);
        var container = document.getElementById(this.uuid);
        if (this.getMold() == 'material') {
            var chart = new google.charts.Column(container);
            // TODO set option bars: 'vertical'
        } else {
            var chart = new google.visualization.ColumnChart(container);
        }
        chart.draw(data, this._chartOptions);
    },
    bind_: function () {
        this.$supers(zul.googlecharts.ColumnChart, 'bind_', arguments);
        var self = this;
        google.setOnLoadCallback(function () {
            self.doDrawChart_();
        });
    },
    unbind_: function () {
        this.$supers(zul.googlecharts.ColumnChart, 'unbind_', arguments);
    }

});