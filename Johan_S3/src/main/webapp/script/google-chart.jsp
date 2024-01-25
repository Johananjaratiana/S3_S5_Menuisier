    <script src="assets/chart/google-loader.js"></script>
    <script>
        google.charts.load('current', {'packages':['corechart']});
        google.charts.setOnLoadCallback(drawChart);

        function drawChart() {
        const data = google.visualization.arrayToDataTable([
        ['Contry', 'Mhl'],
        ['Italy',54.8],
        ['France',48.6],
        ['Spain',44.4],
        ['USA',23.9],
        ['Argentina',14.5]
        ]);

        const options = {
        title:'World Wide Wine Production',
        is3D:true
        };

        // const chart = new google.visualization.PieChart(document.getElementById('google-chart'));
        const chart = new google.visualization.BarChart(document.getElementById('google-chart'));
        chart.draw(data, options);
        }
    </script>