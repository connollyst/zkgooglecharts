# zkgooglecharts
ZK Wrapper for Google Charts

## Download

#### Maven

    <dependency>
    	<groupId>org.zkoss</groupId>
    	<artifactId>zkgooglecharts</artifactId>
    	<version>0.1.9</version>
    </dependency>

#### Gradle

    runtime group: 'org.zkoss', name: 'zkgooglecharts', version: '0.1.9'

## Demo

A small demo app is included to showcase functionality and use. To run the demo with Maven, start Jetty:

    mvn jetty:run
    
and navigate to [http://localhost:8080/zkgooglecharts/](http://localhost:8080/zkgooglecharts/)

## Supported Charts

The following Google Charts are provided at this time:

- [``PieChart``](/src/main/java/org/zkoss/google/charts/PieChart.java)
- [``BarChart``](/src/main/java/org/zkoss/google/charts/BarChart.java)
- [``ColumnChart``](/src/main/java/org/zkoss/google/charts/ColumnChart.java)
- [``Timeline``](/src/main/java/org/zkoss/google/charts/Timeline.java)

More will be supported in future releases.