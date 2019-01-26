#-------------------------------------------------one-way------------------------------------------------

import Adafruit_BBIO.GPIO as GPIO
import time
num=3
GPIO.setup("P9_11",GPIO.OUT)
GPIO.setup("P9_12",GPIO.OUT)
GPIO.setup("P9_13",GPIO.OUT)
GPIO.setup("P9_14",GPIO.OUT)
GPIO.setup("P9_15",GPIO.OUT)
GPIO.setup("P9_16",GPIO.OUT)
GPIO.setup("P9_23",GPIO.OUT)
GPIO.setup("P9_24",GPIO.OUT)
GPIO.setup("P8_11",GPIO.OUT)
GPIO.setup("P8_12",GPIO.OUT)
GPIO.setup("P8_13",GPIO.OUT)
GPIO.setup("P8_14",GPIO.OUT)
GPIO.setup("P8_17",GPIO.OUT)
GPIO.setup("P8_18",GPIO.OUT)
GPIO.setup("P8_7",GPIO.OUT)
GPIO.setup("P8_15",GPIO.OUT)
GPIO.setup("P8_16",GPIO.OUT)
GPIO.setup("P8_8",GPIO.OUT)


while True:
    GPIO.output("P9_23",GPIO.LOW)
    
    GPIO.output("P9_11",GPIO.HIGH)
    GPIO.output("P8_11",GPIO.HIGH)
    GPIO.output("P8_18",GPIO.HIGH)
    
    GPIO.output("P9_12",GPIO.HIGH)
    GPIO.output("P9_14",GPIO.HIGH)
    
    time.sleep(5)
    
    GPIO.output("P9_12",GPIO.LOW)
    GPIO.output("P9_14",GPIO.LOW)
    
    while num>0:

        GPIO.output("P9_16",GPIO.HIGH)
        time.sleep(1)
        GPIO.output("P9_16",GPIO.LOW)
        time.sleep(1)
        num = num-1
    
    
    #------------------------------------------------------
    GPIO.output("P8_18",GPIO.LOW)
    
    GPIO.output("P9_23",GPIO.HIGH)
    GPIO.output("P8_11",GPIO.HIGH)
    GPIO.output("P9_11",GPIO.HIGH)
    
    GPIO.output("P8_14",GPIO.HIGH)
    GPIO.output("P8_12",GPIO.HIGH)
    
    time.sleep(5)
    
    GPIO.output("P8_14",GPIO.LOW)
    GPIO.output("P8_12",GPIO.LOW)
    num=3
    while num>0:

        GPIO.output("P8_16",GPIO.HIGH)
        time.sleep(1)
        GPIO.output("P8_16",GPIO.LOW)
        time.sleep(1)
        num = num-1
    #-----------------------------------------------------------
    GPIO.output("P8_11",GPIO.LOW)
    
    GPIO.output("P9_23",GPIO.HIGH)
    GPIO.output("P8_18",GPIO.HIGH)
    GPIO.output("P9_11",GPIO.HIGH)
    
    GPIO.output("P8_15",GPIO.HIGH)
    GPIO.output("P8_17",GPIO.HIGH)
    
    time.sleep(5)
    
    GPIO.output("P8_15",GPIO.LOW)
    GPIO.output("P8_17",GPIO.LOW)
    num=3
    while num>0:

        GPIO.output("P8_13",GPIO.HIGH)
        time.sleep(1)
        GPIO.output("P8_13",GPIO.LOW)
        time.sleep(1)
        num = num-1
    #---------------------------------------------------------------------------
    GPIO.output("P9_11",GPIO.LOW)
    
    GPIO.output("P9_23",GPIO.HIGH)
    GPIO.output("P8_11",GPIO.HIGH)
    GPIO.output("P8_18",GPIO.HIGH)
    
    GPIO.output("P9_24",GPIO.HIGH)
    GPIO.output("P9_15",GPIO.HIGH)
    
    time.sleep(5)
    
    GPIO.output("P9_24",GPIO.LOW)
    GPIO.output("P9_15",GPIO.LOW)
    num=3
    while num>0:

        GPIO.output("P9_13",GPIO.HIGH)
        time.sleep(1)
        GPIO.output("P9_13",GPIO.LOW)
        time.sleep(1)
        num = num-1

#---------------------------------two-way------------------------------------------------------------------------------


import Adafruit_BBIO.GPIO as GPIO
import time
num=5
GPIO.setup("P9_11",GPIO.OUT)
GPIO.setup("P9_12",GPIO.OUT)
GPIO.setup("P9_13",GPIO.OUT)
GPIO.setup("P9_14",GPIO.OUT)
GPIO.setup("P9_15",GPIO.OUT)
GPIO.setup("P9_16",GPIO.OUT)
GPIO.setup("P9_23",GPIO.OUT)
GPIO.setup("P9_24",GPIO.OUT)
GPIO.setup("P8_11",GPIO.OUT)
GPIO.setup("P8_12",GPIO.OUT)
GPIO.setup("P8_13",GPIO.OUT)
GPIO.setup("P8_14",GPIO.OUT)
GPIO.setup("P8_17",GPIO.OUT)
GPIO.setup("P8_18",GPIO.OUT)
GPIO.setup("P8_7",GPIO.OUT)
GPIO.setup("P8_15",GPIO.OUT)
GPIO.setup("P8_16",GPIO.OUT)
GPIO.setup("P8_8",GPIO.OUT)


while True:
    GPIO.output("P9_11",GPIO.HIGH)
    GPIO.output("P8_18",GPIO.HIGH)
    GPIO.output("P9_14",GPIO.HIGH)
    GPIO.output("P9_12",GPIO.HIGH)
    GPIO.output("P8_15",GPIO.HIGH)
    GPIO.output("P8_17",GPIO.HIGH)
    
    time.sleep(5)
    GPIO.output("P9_11",GPIO.LOW)
    GPIO.output("P8_18",GPIO.LOW)
    GPIO.output("P9_14",GPIO.LOW)
    GPIO.output("P9_12",GPIO.LOW)
    GPIO.output("P8_15",GPIO.LOW)
    GPIO.output("P8_17",GPIO.LOW)
    
    
    while num>0:
        GPIO.output("P9_13",GPIO.HIGH)
        GPIO.output("P8_16",GPIO.HIGH)
        time.sleep(1)
        GPIO.output("P9_13",GPIO.LOW)
        GPIO.output("P8_16",GPIO.LOW)
        time.sleep(1)
        num = num-1
    
    
    
    GPIO.output("P9_23",GPIO.HIGH)
    GPIO.output("P8_11",GPIO.HIGH)
    GPIO.output("P9_24",GPIO.HIGH)
    GPIO.output("P9_15",GPIO.HIGH)
    GPIO.output("P8_14",GPIO.HIGH)
    GPIO.output("P8_12",GPIO.HIGH)
    
    time.sleep(5)
    GPIO.output("P9_23",GPIO.LOW)
    GPIO.output("P8_11",GPIO.LOW)
    GPIO.output("P9_24",GPIO.LOW)
    GPIO.output("P9_15",GPIO.LOW)
    GPIO.output("P8_14",GPIO.LOW)
    GPIO.output("P8_12",GPIO.LOW)
    
    num = 5
    while num>0:
        GPIO.output("P8_13",GPIO.HIGH)
        GPIO.output("P9_16",GPIO.HIGH)
        time.sleep(1)
        GPIO.output("P8_13",GPIO.LOW)
        GPIO.output("P9_16",GPIO.LOW)
        time.sleep(1)
        num = num-1
        
    



