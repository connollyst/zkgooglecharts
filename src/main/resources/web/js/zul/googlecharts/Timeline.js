zul.googlecharts.Timeline = zk.$extends(zul.googlecharts.GoogleChart, {

    // protected //

    doDrawChart_: function () {
        var widget = this;
        var chart = new google.visualization.Timeline(this.container_());
        google.visualization.events.addListener(chart, 'ready', function () {
            widget.fire('onReady', '');
        });
        this.drawChart_(chart);

    },
    bind_: function () {
        this.$supers(zul.googlecharts.Timeline, 'bind_', arguments);
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