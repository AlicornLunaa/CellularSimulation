#version 330
out vec4 FragColor;

uniform vec3 color;

void main(){
    FragColor = vec4(color, 1.0);
    //FragColor = vec4(1.0, 0.0, 0.0, 1.0);
}