zul.googlecharts.ColumnChart = zk.$extends(zul.googlecharts.GoogleChart, {

    // protected //

    doDrawChart_: function () {
        this.drawChart_(new google.visualization.ColumnChart(this.container_()));
    },
    bind_: function () {
        this.$supers(zul.googlecharts.ColumnChart, 'bind_', arguments);
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