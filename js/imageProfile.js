var modal = document.getElementById("myModal");
var photo = document.getElementById("image_pro");
// Get the image and insert it inside the modal - use its "alt" text as a caption
var img = document.getElementById("overlay");
var modalImg = document.getElementById("img01");

img.onclick = function(){
  modal.style.display = "block";
  modalImg.src = image_pro.src;
 
}

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks on <span> (x), close the modal
span.onclick = function() { 
  modal.style.display = "none";
}



var div;
function afficher(select){
    var autre = div || document.getElementById("autreMotif")
    var nouv = div || document.getElementById("essentiel-3-calendrier")

        i = select.selectedIndex;
    autre.style.display = (select.options[i].value == "autre") ? "block" : "none";
    nouv.style.display = (select.options[i].value == "nouv") ? "block" : "none";
}


$(document).ready(function() {
  $('input[type="radio"]').click(function() {
      if($(this).attr('id') == 'sur-place') {
           $('.essentiel-2-calendrier').show();           
      }
      else if ($(this).attr('id') == 'en-video') {
          $('.essentiel-2-calendrier').show();  
      }
      
      else {
           $('.essentiel-2-calendrier').hide();   
      }
  });
});


 window.FonctionNouv = function() {
  
  var hasValue = document.getElementById('motif').value;
  if (!!hasValue) {
    document.getElementById('essentiel-3-calendrier').style.display = 'inline';
  } else {
    document.getElementById('essentiel-3-calendrier').style.display = 'none';
  };
 };