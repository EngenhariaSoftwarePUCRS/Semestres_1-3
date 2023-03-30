#include <stdio.h>
#include "lib_ppm.h"

int main()
{
	struct image_s data;
	struct image_s *image = &data;
	int i, j, r;

	r = read_ppm("lena.ppm", image);

	if (r == 0)
	{
		printf("width: %d, height: %d\n", image->width, image->height);
		for (j = 0; j < image->height; j++)
		{
			for (i = 0; i < image->width; i++)
			{
				printf("(%d %d) %02x %02x %02x\n", i, j,
					   image->pix[j * image->width + i].r,
					   image->pix[j * image->width + i].g,
					   image->pix[j * image->width + i].b);
			}
		}

		image->pix[50 * image->width + 20].r = 255;
		image->pix[50 * image->width + 20].g = 255;
		image->pix[50 * image->width + 20].b = 255;

		write_ppm("lena_copy.ppm", image);

		free_ppm(image);
	}

	r = new_ppm(image, 675, 428);

	if (r == 0)
	{
		image->pix[100 * image->width + 125].r = 255;
		image->pix[27 * image->width + 440].g = 255;

		image->pix[371 * image->width + 10].r = 192;
		image->pix[371 * image->width + 10].g = 192;
		image->pix[371 * image->width + 10].b = 192;

		write_ppm("test.ppm", image);
		free_ppm(image);
	}

	return 0;
}
