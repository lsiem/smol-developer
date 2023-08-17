```javascript
// Image Editor JavaScript Functions

// Function to apply filters to the image
function applyFilter(filterName) {
    var canvas = document.getElementById('imageCanvas');
    var context = canvas.getContext('2d');
    var imageData = context.getImageData(0, 0, canvas.width, canvas.height);
    var data = imageData.data;

    switch(filterName) {
        case 'grayscale':
            for (var i = 0; i < data.length; i += 4) {
                var avg = (data[i] + data[i + 1] + data[i + 2]) / 3;
                data[i]     = avg; // red
                data[i + 1] = avg; // green
                data[i + 2] = avg; // blue
            }
            break;
        // Add more filters as needed
    }

    context.putImageData(imageData, 0, 0);
}

// Function to load image into canvas
function loadImage(input) {
    var reader = new FileReader();
    reader.onload = function(event) {
        var img = new Image();
        img.onload = function() {
            var canvas = document.getElementById('imageCanvas');
            canvas.width = img.width;
            canvas.height = img.height;
            var context = canvas.getContext('2d');
            context.drawImage(img, 0, 0, img.width, img.height);
        }
        img.src = event.target.result;
    }
    reader.readAsDataURL(input.files[0]);
}

// Event listener for file input
document.getElementById('fileInput').addEventListener('change', function() {
    loadImage(this);
});

// Event listeners for filter buttons
document.getElementById('grayscaleButton').addEventListener('click', function() {
    applyFilter('grayscale');
});

// Add more event listeners for other filter buttons as needed
```