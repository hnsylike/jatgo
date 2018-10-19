/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.kafang.atgo.memory.avro.record;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class MdEntry extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -8651606770180938332L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"MdEntry\",\"namespace\":\"com.kafang.atgo.memory.avro.record\",\"fields\":[{\"name\":\"price\",\"type\":\"double\"},{\"name\":\"volume\",\"type\":\"long\"},{\"name\":\"level\",\"type\":\"int\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<MdEntry> ENCODER =
      new BinaryMessageEncoder<MdEntry>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<MdEntry> DECODER =
      new BinaryMessageDecoder<MdEntry>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<MdEntry> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<MdEntry> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<MdEntry>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this MdEntry to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a MdEntry from a ByteBuffer. */
  public static MdEntry fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private double price;
   private long volume;
   private int level;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public MdEntry() {}

  /**
   * All-args constructor.
   * @param price The new value for price
   * @param volume The new value for volume
   * @param level The new value for level
   */
  public MdEntry(java.lang.Double price, java.lang.Long volume, java.lang.Integer level) {
    this.price = price;
    this.volume = volume;
    this.level = level;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return price;
    case 1: return volume;
    case 2: return level;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: price = (java.lang.Double)value$; break;
    case 1: volume = (java.lang.Long)value$; break;
    case 2: level = (java.lang.Integer)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'price' field.
   * @return The value of the 'price' field.
   */
  public java.lang.Double getPrice() {
    return price;
  }

  /**
   * Sets the value of the 'price' field.
   * @param value the value to set.
   */
  public com.kafang.atgo.memory.avro.record.MdEntry setPrice(java.lang.Double value) {
    this.price = value;
	return this;
  }

  /**
   * Gets the value of the 'volume' field.
   * @return The value of the 'volume' field.
   */
  public java.lang.Long getVolume() {
    return volume;
  }

  /**
   * Sets the value of the 'volume' field.
   * @param value the value to set.
   */
  public com.kafang.atgo.memory.avro.record.MdEntry setVolume(java.lang.Long value) {
    this.volume = value;
	return this;
  }

  /**
   * Gets the value of the 'level' field.
   * @return The value of the 'level' field.
   */
  public java.lang.Integer getLevel() {
    return level;
  }

  /**
   * Sets the value of the 'level' field.
   * @param value the value to set.
   */
  public com.kafang.atgo.memory.avro.record.MdEntry setLevel(java.lang.Integer value) {
    this.level = value;
	return this;
  }

  /**
   * Creates a new MdEntry RecordBuilder.
   * @return A new MdEntry RecordBuilder
   */
  public static com.kafang.atgo.memory.avro.record.MdEntry.Builder newBuilder() {
    return new com.kafang.atgo.memory.avro.record.MdEntry.Builder();
  }

  /**
   * Creates a new MdEntry RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new MdEntry RecordBuilder
   */
  public static com.kafang.atgo.memory.avro.record.MdEntry.Builder newBuilder(com.kafang.atgo.memory.avro.record.MdEntry.Builder other) {
    return new com.kafang.atgo.memory.avro.record.MdEntry.Builder(other);
  }

  /**
   * Creates a new MdEntry RecordBuilder by copying an existing MdEntry instance.
   * @param other The existing instance to copy.
   * @return A new MdEntry RecordBuilder
   */
  public static com.kafang.atgo.memory.avro.record.MdEntry.Builder newBuilder(com.kafang.atgo.memory.avro.record.MdEntry other) {
    return new com.kafang.atgo.memory.avro.record.MdEntry.Builder(other);
  }

  /**
   * RecordBuilder for MdEntry instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<MdEntry>
    implements org.apache.avro.data.RecordBuilder<MdEntry> {

    private double price;
    private long volume;
    private int level;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.kafang.atgo.memory.avro.record.MdEntry.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.price)) {
        this.price = data().deepCopy(fields()[0].schema(), other.price);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.volume)) {
        this.volume = data().deepCopy(fields()[1].schema(), other.volume);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.level)) {
        this.level = data().deepCopy(fields()[2].schema(), other.level);
        fieldSetFlags()[2] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing MdEntry instance
     * @param other The existing instance to copy.
     */
    private Builder(com.kafang.atgo.memory.avro.record.MdEntry other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.price)) {
        this.price = data().deepCopy(fields()[0].schema(), other.price);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.volume)) {
        this.volume = data().deepCopy(fields()[1].schema(), other.volume);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.level)) {
        this.level = data().deepCopy(fields()[2].schema(), other.level);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'price' field.
      * @return The value.
      */
    public java.lang.Double getPrice() {
      return price;
    }

    /**
      * Sets the value of the 'price' field.
      * @param value The value of 'price'.
      * @return This builder.
      */
    public com.kafang.atgo.memory.avro.record.MdEntry.Builder setPrice(double value) {
      validate(fields()[0], value);
      this.price = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'price' field has been set.
      * @return True if the 'price' field has been set, false otherwise.
      */
    public boolean hasPrice() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'price' field.
      * @return This builder.
      */
    public com.kafang.atgo.memory.avro.record.MdEntry.Builder clearPrice() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'volume' field.
      * @return The value.
      */
    public java.lang.Long getVolume() {
      return volume;
    }

    /**
      * Sets the value of the 'volume' field.
      * @param value The value of 'volume'.
      * @return This builder.
      */
    public com.kafang.atgo.memory.avro.record.MdEntry.Builder setVolume(long value) {
      validate(fields()[1], value);
      this.volume = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'volume' field has been set.
      * @return True if the 'volume' field has been set, false otherwise.
      */
    public boolean hasVolume() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'volume' field.
      * @return This builder.
      */
    public com.kafang.atgo.memory.avro.record.MdEntry.Builder clearVolume() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'level' field.
      * @return The value.
      */
    public java.lang.Integer getLevel() {
      return level;
    }

    /**
      * Sets the value of the 'level' field.
      * @param value The value of 'level'.
      * @return This builder.
      */
    public com.kafang.atgo.memory.avro.record.MdEntry.Builder setLevel(int value) {
      validate(fields()[2], value);
      this.level = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'level' field has been set.
      * @return True if the 'level' field has been set, false otherwise.
      */
    public boolean hasLevel() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'level' field.
      * @return This builder.
      */
    public com.kafang.atgo.memory.avro.record.MdEntry.Builder clearLevel() {
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    public MdEntry build() {
      try {
        MdEntry record = new MdEntry();
        record.price = fieldSetFlags()[0] ? this.price : (java.lang.Double) defaultValue(fields()[0]);
        record.volume = fieldSetFlags()[1] ? this.volume : (java.lang.Long) defaultValue(fields()[1]);
        record.level = fieldSetFlags()[2] ? this.level : (java.lang.Integer) defaultValue(fields()[2]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<MdEntry>
    WRITER$ = (org.apache.avro.io.DatumWriter<MdEntry>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<MdEntry>
    READER$ = (org.apache.avro.io.DatumReader<MdEntry>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}