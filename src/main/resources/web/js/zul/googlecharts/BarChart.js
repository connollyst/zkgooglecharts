zul.googlecharts.BarChart = zk.$extends(zul.googlecharts.GoogleChart, {

    // protected //

    doDrawChart_: function () {
        console.log('Drawing bar chart..');
        console.log(this._chartData);
        console.log(this._chartOptions);
        console.log('Rendering bar chart into ' + this.uuid);
        this.drawChart_(new google.visualization.BarChart(this.container_()));
    },
    bind_: function () {
        console.log('Binding BarChart: ' + JSON.stringify(this));
        this.$supers(zul.googlecharts.BarChart, 'bind_', arguments);
        var self = this;
        if (!zul.googlecharts.GoogleChart.googleLoaded) {
            zul.googlecharts.GoogleChart.addOnLoadCallback(function () {
                self.doDrawChart_()
            });
        } else {
            self.doDrawChart_();
        }
    }

});