zul.googlecharts.PieChart = zk.$extends(zk.Widget, {

    doDrawChart: function () {
        console.log("Drawing..");
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Topping');
        data.addColumn('number', 'Slices');
        data.addRows([
            ['Mushrooms', 3],
            ['Onions', 1],
            ['Olives', 1],
            ['Zucchini', 1],
            ['Pepperoni', 2]
        ]);
        var options = {
            'title': 'How Much Pizza I Ate Last Night',
            'width': 400,
            'height': 300
        };
        // Instantiate and draw our chart, passing in some options.
        console.log(this);
        console.log('Rendering pie chart into ' + this.uuid);
        var container = document.getElementById(this.uuid);
        console.log('Rendering pie chart into ' + container);
        var chart = new google.visualization.PieChart(container);
        chart.draw(data, options);
    },
    // protected //
    bind_: function () {
        console.log('Binding widget..');
        this.$supers(zul.googlecharts.PieChart, 'bind_', arguments);
        // Set a callback to run when the Google Visualization API is loaded.
        var self = this;
        google.setOnLoadCallback(function () {
            console.log('Google Charts loaded..');
            self.doDrawChart();
        });
    },
    unbind_: function () {
        this.$supers(zul.googlecharts.PieChart, 'unbind_', arguments);
    }

}, {});