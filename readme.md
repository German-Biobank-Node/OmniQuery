# GBN Query Translator

[Description]

## Usage

```java
// DKTK --> I2B2
DKTKTranslator<I2B2Translator> DKTKtoI2B2Translator = new DKTKTranslator<>(I2B2Translator.class);
String i2b2 = DKTKtoI2B2Translator.translate(xmlAsString);

// I2B2 --> DKTK
I2B2Translator<DKTKTranslator> I2B2toDKTKTranslator = new I2B2Translator<>(DKTKTranslator.class);
String dktk = I2B2toDKTKTranslator.translate(xmlAsString);
```

## License

[License]