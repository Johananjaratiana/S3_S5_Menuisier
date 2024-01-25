    <script src="assets/chart/plotly-latest.min.js"></script>
    <script>
        const xArray = ["Italy", "France", "Spain", "USA", "Argentina"];
        const yArray = [55, 49, 44, 24, 15];

        const layout = {title:"World Wide Wine Production"};

        const data = [{labels:xArray, values:yArray, hole:.4, type:"pie"}];

        Plotly.newPlot("plotly-donut", data, layout);
    </script>