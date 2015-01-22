zul.googlecharts.PieChart = zk.$extends(zul.googlecharts.GoogleChart, {

    // protected //

    doDrawChart_: function () {
        console.log('zkgooglecharts: Drawing pie chart..');
        console.log(this._chartData);
        console.log(this._chartOptions);
        console.log('zkgooglecharts: Rendering pie chart into ' + this.uuid);
        this.drawChart_(new google.visualization.PieChart(this.container_()));
    },
    bind_: function () {
        console.log('zkgooglecharts: Binding PieChart: ' + JSON.stringify(this));
        this.$supers(zul.googlecharts.PieChart, 'bind_', arguments);
        var self = this;
        if (!zul.googlecharts.GoogleChart.googleLoaded) {
            console.log('zkgooglecharts: Google is not loaded, drawing later..');
            zul.googlecharts.GoogleChart.addOnLoadCallback(function () {
                self.doDrawChart_()
            });
        } else {
            console.log('zkgooglecharts: Google is loaded, drawing now..');
            self.doDrawChart_();
        }
    }

});