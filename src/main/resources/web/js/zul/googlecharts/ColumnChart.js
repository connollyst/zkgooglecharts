zul.googlecharts.ColumnChart = zk.$extends(zul.googlecharts.GoogleChart, {

    // protected //

    doDrawChart_: function () {
        var widget = this;
        var chart = new google.visualization.ColumnChart(this.container_());
        google.visualization.events.addListener(chart, 'animationfinish', function () {
            widget.fire('onAnimationFinish');
        });
        google.visualization.events.addListener(chart, 'click', function (evt) {
            widget.fire('onClick', evt);
        });
        this.drawChart_(chart);
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