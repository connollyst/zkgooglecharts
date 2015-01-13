// ZK mold JavaScript
// Note: all charts share the same mold here, a simple div placeholder.
// The widget code handles the differences between charts.
function (out) {
    out.push('<div ', this.domAttrs_(), '></div>');
}