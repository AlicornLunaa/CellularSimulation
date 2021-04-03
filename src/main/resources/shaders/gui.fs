#version 330 core
in vec2 texCoord;

out vec4 FragColor;

uniform vec3 color;
uniform sampler2D tex0;

void main(){
    FragColor = texture(tex0, texCoord) * vec4(color, 1.0);
}