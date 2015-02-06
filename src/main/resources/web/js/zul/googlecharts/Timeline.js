zul.googlecharts.Timeline = zk.$extends(zul.googlecharts.GoogleChart, {

    // protected //

    doDrawChart_: function () {
        console.log('zkgooglecharts: Drawing timeline..');
        console.log(this._chartData);
        console.log(this._chartOptions);
        console.log('zkgooglecharts: Rendering timeline into ' + this.uuid);
        this.drawChart_(new google.visualization.Timeline(this.container_()));
    },
    bind_: function () {
        console.log('zkgooglecharts: Binding Timeline');
        this.$supers(zul.googlecharts.Timeline, 'bind_', arguments);
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