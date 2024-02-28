    <script src="assets/chart/plotly-latest.min.js"></script>
    <script>
        // const xArray = ["Italy", "France", "Spain", "USA", "Argentina"];
        // const yArray = [55, 49, 44, 24, 15];

        var xArray = document.getElementById("x_benefice_rentable").firstChild.textContent.replace("[", "").replace("]", "").replaceAll("\"", "").split(", ");
        var yArray = document.getElementById("y_benefice_rentable").firstChild.textContent.replace("[", "").replace("]", "").split(", ");
      
        const layout = {title:"Les meubles rentables"};

        const data = [{labels:xArray, values:yArray, hole:.4, type:"pie"}];

        Plotly.newPlot("plotly-donut-benefice-general-rentable", data, layout);
    </script>