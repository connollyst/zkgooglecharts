zul.googlecharts.PieChart = zk.$extends(zk.Widget, {

    // protected //
    bind_: function () {
        this.$supers(zul.googlecharts.PieChart, 'bind_', arguments);
    },
    unbind_: function () {
        this.$supers(zul.googlecharts.PieChart, 'unbind_', arguments);
    }

}, {});