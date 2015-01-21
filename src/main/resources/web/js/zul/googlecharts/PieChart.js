zul.googlecharts.PieChart = zk.$extends(zul.googlecharts.GoogleChart, {

    // protected //

    doDrawChart_: function () {
        console.log("Drawing pie chart..");
        console.log(this._chartData);
        console.log(this._chartOptions);
        console.log('Rendering pie chart into ' + this.uuid);
        this.drawChart_(new google.visualization.PieChart(this.container_()));
    },
    bind_: function () {
        console.log('Binding PieChart: ' + JSON.stringify(this));
        this.$supers(zul.googlecharts.PieChart, 'bind_', arguments);
        var self = this;
        if (!zul.googlecharts.GoogleChart.googleLoaded) {
            console.log('Google is not loaded, drawing later..');
            zul.googlecharts.GoogleChart.addOnLoadCallback(function () {
                self.doDrawChart_()
            });
        } else {
            console.log('Google is loaded, drawing now..');
            self.doDrawChart_();
        }
    }

});