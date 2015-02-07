zul.googlecharts.PieChart = zk.$extends(zul.googlecharts.GoogleChart, {

    // protected //

    doDrawChart_: function () {
        this.drawChart_(new google.visualization.PieChart(this.container_()));
    },
    bind_: function () {
        this.$supers(zul.googlecharts.PieChart, 'bind_', arguments);
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