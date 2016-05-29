# zkgooglecharts
ZK Wrapper for [Google Charts](https://developers.google.com/chart/) visualizations.

## Download

#### Maven

    <dependency>
    	<groupId>org.zkoss</groupId>
    	<artifactId>zkgooglecharts</artifactId>
    	<version>0.3.0</version>
    </dependency>

#### Gradle

    runtime group: 'org.zkoss', name: 'zkgooglecharts', version: '0.3.0'

## Demo

A small demo app is included to showcase functionality and use. To run the demo with Maven, start Jetty:

    mvn jetty:run
    
and navigate to [http://localhost:8080/zkgooglecharts/](http://localhost:8080/zkgooglecharts/)

## Supported Charts

The following Google Charts are provided at this time:

- [``org.zkoss.google.charts.PieChart``](/src/main/java/org/zkoss/google/charts/PieChart.java)
- [``org.zkoss.google.charts.BarChart``](/src/main/java/org/zkoss/google/charts/BarChart.java)
- [``org.zkoss.google.charts.ColumnChart``](/src/main/java/org/zkoss/google/charts/ColumnChart.java)
- [``org.zkoss.google.charts.Timeline``](/src/main/java/org/zkoss/google/charts/Timeline.java)

More will be supported in future releases.

## Quick Start

#### ZUL

Charts can be added to any ZK component and configured directly in ZUL. Data, however, must be initialized in Java.

    <zk>
    	<zscript>
            DataTable data = new DataTable();
            data.addStringColumn("Task", "task");
            data.addNumberColumn("Hours per Day", "hours");
            data.addRow("Work", 11);
            data.addRow("Eat", 2);
            data.addRow("Commute", 2);
            data.addRow("Watch TV", 2);
            data.addRow("Sleep", new FormattedValue(7, "7.000"));
    	</zscript>
    	<piechart 3D="true" data="${data}"/>
    </zk>

#### Java

The above can all be done directly in Java, of course.

    DataTable data = new DataTable();
    data.addStringColumn("Task", "task");
    data.addNumberColumn("Hours per Day", "hours");
    data.addRow("Work", 11);
    data.addRow("Eat", 2);
    data.addRow("Commute", 2);
    data.addRow("Watch TV", 2);
    data.addRow("Sleep", new FormattedValue(7, "7.000"));
    
    PieChart chart = new PieChart();
    chart.set3D(true);
    chart.setData(data);
    chart.setParent(window);

## Chart Data

zkgooglecharts provides [org.zkoss.google.charts.data.DataTable](/src/main/java/org/zkoss/google/charts/data/DataTable.java) which aims to be functionally equivalent to Google Chart's [``google.visualization.DataTable``](https://developers.google.com/chart/interactive/docs/reference#DataTable) class. All charts have a ``setData(DataTable data)`` function, though the expected/supported structure may be different for each.

A ``DataTable`` consists of columns and rows. Columns are typed, to assist Google Chart rendering, though not strictly in code.

## Examples

### Pie Chart Example

    DataTable data = new DataTable();
    data.addStringColumn("Task", "task");
    data.addNumberColumn("Hours per Day", "hours");
    data.addRow("Work", 11);
    data.addRow("Eat", 2);
    data.addRow("Commute", 2);
    data.addRow("Watch TV", 2);
    data.addRow("Sleep", new FormattedValue(7, "7.000"));
    
    PieChart chart = new PieChart();
    chart.setData(data);

Produces the pie chart example seen [here](https://developers.google.com/chart/interactive/docs/gallery/piechart#Example).

### Bar Chart Eaxmple

    DataTable data = new DataTable();
    data.addStringColumn("City");
    data.addNumberColumn("2010 Population");
    data.addRow("New York City, NY", 8175000);
    data.addRow("Los Angeles, CA",   3792000);
    data.addRow("Chicago, IL",       2695000);
    data.addRow("Houston, TX",       2099000);
    data.addRow("Philadelphia, PA",  1526000);

    Map<String, Object> hAxis = new HashMap<>();
    Map<String, Object> vAxis = new HashMap<>();
    hAxis.put("title", "Total Population");
    hAxis.put("minValue", 0);
    vAxis.put("title", "City");
    
    BarChart chart = new BarChart();
    chart.setData(data);
    chart.setTitle("Population of Largest U.S. Cities");
    chart.setWidth(1000);
    chart.setHeight(563);
    chart.setOption("hAxis", hAxis);
    chart.setOption("vAxis", vAxis);
    
Produces the bar chart example seen [here](https://developers.google.com/chart/interactive/docs/gallery/barchart#Examples).

Note that some options are supported directly, such as ``setTitle``, but others are not and need to be specified explicitly using ``setOption``. In the above example, to configure the horizontal and vertical axes, we use ``setOption``.

Multiple data series can be displayed by adding more columns.

    DataTable data = new DataTable();
    data.addStringColumn("City");
    data.addNumberColumn("2010 Population");
    data.addNumberColumn("2000 Population");
    data.addRow("New York City, NY", 8175000, 8008000);
    data.addRow("Los Angeles, CA",   3792000, 3694000);
    data.addRow("Chicago, IL",       2695000, 2896000);
    data.addRow("Houston, TX",       2099000, 1953000);
    data.addRow("Philadelphia, PA",  1526000, 1517000);

    Map<String, Object> hAxis = new HashMap<>();
    Map<String, Object> vAxis = new HashMap<>();
    hAxis.put("title", "Total Population");
    hAxis.put("minValue", 0);
    vAxis.put("title", "City");
    
    BarChart chart = new BarChart();
    chart.setData(data);
    chart.setTitle("Population of Largest U.S. Cities");
    chart.setWidth(1000);
    chart.setHeight(563);
    chart.setOption("hAxis", hAxis);
    chart.setOption("vAxis", vAxis);

Produces the 2nd bar chart example seen [here](https://developers.google.com/chart/interactive/docs/gallery/barchart#Examples) (scroll example to right or left).

### Timeline Example

The Timeline data structure differs from the Pie, Bar, or Column charts.

    DataTable data = new DataTable();
    data.addStringColumn("President");
    data.addDateColumn("Start");
    data.addDateColumn("End");
    dataTable.addRow("Washington",
                     new GregorianCalendar(1789, 3, 29).getTime(),
                     new GregorianCalendar(1797, 2,  3).getTime()
    );
    dataTable.addRow("Adams",
                     new GregorianCalendar(1797, 2, 3).getTime(),
                     new GregorianCalendar(1801, 2, 3).getTime()
    );
    dataTable.addRow("Jefferson",
                     new GregorianCalendar(1801, 2, 3).getTime(),
                     new GregorianCalendar(1809, 2, 3).getTime()
    );

    Timeline chart = new Timeline();
    chart.setData(data);
    
Produces the timeline example seen [here](https://developers.google.com/chart/interactive/docs/gallery/timeline#SimpleExample).

## License

zkgooglecharts and Google Charts are available under the [Apache 2.0 License](http://www.apache.org/licenses/LICENSE-2.0).

## Credit

Google Charts is developed by Google.

zkgooglecharts is devolped by [Sean Connolly](https://github.com/connollyst).