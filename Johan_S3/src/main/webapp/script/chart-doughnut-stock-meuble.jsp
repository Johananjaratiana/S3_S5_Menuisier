    <script>
      // var x_Values = ["Italy", "France", "Spain", "USA", "Argentina"];
      // var yValues = [55, 49, 44, 24, 15];

      var x_Values = document.getElementById("x_stock_meuble_restante").firstChild.textContent.replace("[", "").replace("]", "").replaceAll("\"", "").split(", ");
      var yValues = document.getElementById("y_stock_meuble_restante").firstChild.textContent.replace("[", "").replace("]", "").split(", ");
      
      
      var barColors = [
        "#b91d47",
        "#00aba9",
        "#2b5797",
        "#e8c3b9",
        "#1e7145"
      ];

      new Chart("chart-doughnut-stock-meuble", {
        type: "doughnut",
        data: {
          labels: x_Values,
          datasets: [{
            backgroundColor: barColors,
            data: yValues
          }]
        },
        options: {
          title: {
            display: true,
            text: "Quelle meuble a encore plusieurs stock ?"
          }
        }
      });
    </script>