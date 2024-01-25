    
    <script src="assets/js/chart.js"></script>
    <script>
      var homme_part = parseFloat(document.getElementById("homme-part").innerHTML);
      var femme_part = parseFloat(document.getElementById("femme-part").innerHTML);
      var xValues = ["Homme", "Femme"];
      var yValues = [homme_part, femme_part];
      var barColors = [
        "#b91d47",
        "#00aba9",
        "#2b5797",
        "#e8c3b9",
        "#1e7145"
      ];

      new Chart("myChart", {
        type: "pie",
        data: {
          labels: xValues,
          datasets: [{
            backgroundColor: barColors,
            data: yValues
          }]
        },
        options: {
          title: {
            display: true,
            text: "Statistiques"
          }
        }
      });
    </script>