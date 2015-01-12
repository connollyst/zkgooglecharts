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
        var data = new google.visualization.DataTable();
        for (var type in this._chartData['columns']) {
            var label = this._chartData['columns'][type];
            console.log(type + " = " + label);
            data.addColumn(type, label);
        }
        for (var key in this._chartData['rows']) {
            var value = this._chartData['rows'][key];
            data.addRow([key, value]);
        }
        // Instantiate and draw our chart, passing in some options.
        console.log('Rendering pie chart into ' + this.uuid);
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