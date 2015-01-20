zul.googlecharts.ColumnChart = zk.$extends(zul.googlecharts.GoogleChart, {

    // protected //

    doDrawChart_: function () {
        console.log("Drawing column chart..");
        console.log(this._chartData);
        console.log(this._chartOptions);
        console.log('Rendering column chart into ' + this.uuid);
        this.drawChart_(new google.visualization.ColumnChart(this.container_()));
    },
    bind_: function () {
        console.log('Binding ColumnChart');
        this.$supers(zul.googlecharts.ColumnChart, 'bind_', arguments);
        var self = this;
        if (!zul.googlecharts.GoogleChart.googleLoaded) {
            zul.googlecharts.GoogleChart.addOnLoadCallback(function () {
                self.doDrawChart_()
            });
        } else {
            self.doDrawChart_();
        }
    },
    unbind_: function () {
        this.$supers(zul.googlecharts.ColumnChart, 'unbind_', arguments);
    }

});