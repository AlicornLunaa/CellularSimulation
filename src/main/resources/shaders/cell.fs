#version 330
in vec2 texCoord;
out vec4 FragColor;
uniform vec3 color;

void main(){
    FragColor = vec4(color, 1.0);
}