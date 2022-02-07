in vec3 pos;

void main()
{
    // gl_Position is a vec4
    gl_Position = vec4(pos.x, pos.y, pos.z, 1);
}