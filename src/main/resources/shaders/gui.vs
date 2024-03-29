#version 330 core
layout (location = 0) in vec3 aPos;
layout (location = 1) in vec2 aTexCoord;

out vec2 texCoord;

uniform mat4 viewMatrix;
uniform mat4 projMatrix;
uniform mat4 modelMatrix;

void main(){
    gl_Position = (projMatrix * viewMatrix * modelMatrix) * vec4(aPos, 1.0);
    texCoord = aTexCoord;
}