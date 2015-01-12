zul.googlecharts.PieChart = zk.$extends(zk.Widget, {

    // protected //
    bind_: function () {
        this.$supers(zul.fontawesome.Icon, 'bind_', arguments);
    },
    unbind_: function () {
        this.$supers(zul.fontawesome.Icon, 'unbind_', arguments);
    }

}, {});