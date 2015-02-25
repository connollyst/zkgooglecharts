zul.googlecharts.BarChart = zk.$extends(zul.googlecharts.GoogleChart, {

    // protected //

    doDrawChart_: function () {
        var chart = new google.visualization.BarChart(this.container_());
        google.visualization.events.addListener(chart, 'ready', function () {
            widget.fire('onReady', chart.getImageURI());
        });
        this.drawChart_(chart);
    },
    bind_: function () {
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