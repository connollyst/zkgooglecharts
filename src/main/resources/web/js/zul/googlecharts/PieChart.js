zul.googlecharts.PieChart = zk.$extends(zk.Widget, {

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
        console.log("Drawing..");
        console.log(this._chartData);
        console.log(this._chartOptions);
        console.log('Rendering pie chart into ' + this.uuid);
        // Instantiate and draw our chart, passing in some options.
        var data = new google.visualization.DataTable(this._chartData);
        var container = document.getElementById(this.uuid);
        var chart = new google.visualization.PieChart(container);
        chart.draw(data, this._chartOptions);
    },
    bind_: function () {
        this.$supers(zul.googlecharts.PieChart, 'bind_', arguments);
        var self = this;
        google.setOnLoadCallback(function () {
            self.doDrawChart_();
        });
    },
    unbind_: function () {
        this.$supers(zul.googlecharts.PieChart, 'unbind_', arguments);
    }

});