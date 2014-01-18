#include <Adafruit_NeoPixel.h>


// Parameter 1 = number of pixels in strip
// Parameter 2 = pin number (most are valid)
// Parameter 3 = pixel type flags, add together as needed:
//   NEO_RGB     Pixels are wired for RGB bitstream
//   NEO_GRB     Pixels are wired for GRB bitstream
//   NEO_KHZ400  400 KHz bitstream (e.g. FLORA pixels)
//   NEO_KHZ800  800 KHz bitstream (e.g. High Density LED strip)
Adafruit_NeoPixel strip = Adafruit_NeoPixel(30, 6, NEO_GRB + NEO_KHZ800);

#define STATEPIN 2

void setup() 
{
  pinMode(STATEPIN, INPUT);

  strip.begin();
  strip.show();
  
  for ( int i = 0; i < strip.numPixels()/2; i++ )
  {
    strip.setPixelColor(i, strip.Color(255,0,0));
    strip.setPixelColor(strip.numPixels()-i, strip.Color(0,0,255));
    strip.show();
    delay(100);
  }
}

void loop() 
{
  if ( !digitalRead(STATEPIN) )
    cycle(strip.Color(255,0,0));
  else
    lazorRed();
}

void cycle(uint32_t color)
{
  _cycle(0, color);
  delay(100);
  _cycle(1, color);
  delay(100);
  _cycle(2, color);
  delay(100);
}

void _cycle(int a, uint32_t color)
{
    for ( uint16_t b = 0; b < strip.numPixels(); b++ )
    {
      if ( b%3 == a )
      {
        strip.setPixelColor(b, color);
      }
      else
      {
        strip.setPixelColor(b, strip.Color(0,0,0));
      }
    }
    strip.show();
}


void lazor(uint32_t color)
{
  for ( uint16_t a = 0; a < strip.numPixels(); a++ )
  {
    for ( uint16_t b = 0; b < strip.numPixels(); b++ )
    {
      strip.setPixelColor(b,strip.Color(0,0,0));
    }
    strip.setPixelColor(a, color);
    strip.show();
    delay(30-a);
  }
}

void lazorRed()
{
  for ( uint16_t a = 0; a < strip.numPixels(); a++ )
  {
    for ( uint16_t b = 0; b < strip.numPixels(); b++ )
    {
      strip.setPixelColor(b,strip.Color(100, 100, 100));
    }
    strip.setPixelColor(a, strip.Color(255, 0, 0));
    strip.setPixelColor(a-1, strip.Color(170, 0, 0));
    strip.setPixelColor(a-2, strip.Color(170, 0, 0));
    strip.setPixelColor(a-3, strip.Color(170, 0, 0));
    
    strip.setPixelColor(a-4,strip.Color(170, 112, 0));
    strip.setPixelColor(a-5, strip.Color(127, 84, 0));
    strip.setPixelColor(a-6, strip.Color(127, 84, 0));
    strip.setPixelColor(a-7, strip.Color(127, 84, 0));
    strip.show();
    delay(13);
  }
}

void solid(uint32_t color)
{
  for ( uint16_t b = 0; b < strip.numPixels(); b++ )
  {
    strip.setPixelColor(b,color);
  }
  strip.show();
}

void fadeFlash()
{
  for ( int i = 0; i < 255; i++ )
  {
    for ( uint16_t b = 0; b < strip.numPixels(); b++ )
    {
        strip.setPixelColor(b,strip.Color(i, 0, 0));
    }
    
    strip.show();
    delay(2);
  }
  
  for ( int i = 255; i > 0; i-- )
  {
    for ( uint16_t b = 0; b < strip.numPixels(); b++ )
    {
        strip.setPixelColor(b,strip.Color(i, 0, 0));
    }
    
    strip.show();
    delay(2);
  }
}
