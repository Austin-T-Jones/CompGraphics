in vec3 color;
out vec4 fragColor;

void mian()
{
	fragColor = vec4(color.r, color.g, color.b, 1);
}