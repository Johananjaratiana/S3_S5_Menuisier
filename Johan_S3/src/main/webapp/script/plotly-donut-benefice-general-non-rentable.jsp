    <script src="assets/chart/plotly-latest.min.js"></script>
    <script>
        // const xArray = ["Italy", "France", "Spain", "USA", "Argentina"];
        // const yArray = [55, 49, 44, 24, 15];

        var x__Array = document.getElementById("x_benefice_non_rentable").firstChild.textContent.replace("[", "").replace("]", "").replaceAll("\"", "").split(", ");
        var y__Array = document.getElementById("y_benefice_non_rentable").firstChild.textContent.replace("[", "").replace("]", "").split(", ");

        const __layout = {title:"Les meubles pas encore rentables"};

        const __data = [{labels:x__Array, values:y__Array, hole:.4, type:"pie"}];

        Plotly.newPlot("plotly-donut-benefice-general-non-rentable", __data, __layout);
    </script>