    <script>
      // const xValues = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12];
      const xValues = ['Janvier', 'Fevrier', 'Mars', 'Avril', 'Mai', 'Juin', 'Juillet', 'Aout', 'Septembre', 'Octobre', 'Novembre', 'Decembre'];
      const statiColor = ['red', 'green', 'brown', 'black', 'blue', 'yellow', 'fuchsia', 'turquoise'];

      var all_X_labels = document.getElementById("x_statistiques_nb_vente_par_style_par_mois_current_year").firstChild.textContent.replace("[", "").replace("]", "").replaceAll("\"", "").split(", ");
      var all_Y_values = document.getElementById("y_statistiques_nb_vente_par_style_par_mois_current_year").firstChild.textContent.replace("[", "").replace("]", "").split(", ");

      const nb_style = all_X_labels.length / 12;
      const real_X_labels = all_X_labels.slice(0,nb_style);


      function Get_real_Y_values_By_X_index(nb_style, x_index, all_Y_values){
        var tabs = []
        for(let index = 0 ; index < all_Y_values.length ; index ++){
          if( (index % nb_style) == (x_index % nb_style) ) tabs.push(all_Y_values[index]);
        }
        return tabs;
      }

      function BuildDataSets(nb_style, real_X_labels, all_Y_values){
        var datasets = [];
        for(let x_index = 0 ; x_index < real_X_labels.length ; x_index++){
          // console.log("#"+x_index+""+x_index+""+x_index+""+x_index);
          datasets.push({
            data: Get_real_Y_values_By_X_index(nb_style, x_index, all_Y_values),
            borderColor: statiColor[x_index % statiColor.length],
            fill: false,
            label: real_X_labels[x_index]
          })
        }
        return datasets;
      }

      new Chart("chart-multiple-lines-vente-style", {
        type: "line",
        data: {
          labels: xValues,
          datasets: BuildDataSets(nb_style, real_X_labels, all_Y_values)
        },
        options: {
          legend: {display: true}
        }
      });
    </script>