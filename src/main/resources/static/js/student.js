$(function() {

    $.get("/majors", function(data) {
        pieChart.createLegend(data);
        loadStudentData();
    });

    var loadStudentData = function(){

        $.get("/students", function(data) {
            var data = data["Total"];
            var femaleData = data["Female"];
            var maleData = data["Male"];

            pieChart.create("Total", data);
        });
    }
});