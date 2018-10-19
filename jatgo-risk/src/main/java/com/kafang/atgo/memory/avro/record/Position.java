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
public class Position extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -5832125463386507139L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Position\",\"namespace\":\"com.kafang.atgo.memory.avro.record\",\"fields\":[{\"name\":\"strategyId\",\"type\":\"int\"},{\"name\":\"clientId\",\"type\":\"int\"},{\"name\":\"accountId\",\"type\":\"int\"},{\"name\":\"instrumentId\",\"type\":\"int\"},{\"name\":\"currentQty\",\"type\":\"int\"},{\"name\":\"tradableQty\",\"type\":\"int\"},{\"name\":\"shortQty\",\"type\":\"int\"},{\"name\":\"lockQty\",\"type\":\"int\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Position> ENCODER =
      new BinaryMessageEncoder<Position>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Position> DECODER =
      new BinaryMessageDecoder<Position>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<Position> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<Position> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Position>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this Position to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a Position from a ByteBuffer. */
  public static Position fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private int strategyId;
   private int clientId;
   private int accountId;
   private int instrumentId;
   private int currentQty;
   private int tradableQty;
   private int shortQty;
   private int lockQty;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Position() {}

  /**
   * All-args constructor.
   * @param strategyId The new value for strategyId
   * @param clientId The new value for clientId
   * @param accountId The new value for accountId
   * @param instrumentId The new value for instrumentId
   * @param currentQty The new value for currentQty
   * @param tradableQty The new value for tradableQty
   * @param shortQty The new value for shortQty
   * @param lockQty The new value for lockQty
   */
  public Position(java.lang.Integer strategyId, java.lang.Integer clientId, java.lang.Integer accountId, java.lang.Integer instrumentId, java.lang.Integer currentQty, java.lang.Integer tradableQty, java.lang.Integer shortQty, java.lang.Integer lockQty) {
    this.strategyId = strategyId;
    this.clientId = clientId;
    this.accountId = accountId;
    this.instrumentId = instrumentId;
    this.currentQty = currentQty;
    this.tradableQty = tradableQty;
    this.shortQty = shortQty;
    this.lockQty = lockQty;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return strategyId;
    case 1: return clientId;
    case 2: return accountId;
    case 3: return instrumentId;
    case 4: return currentQty;
    case 5: return tradableQty;
    case 6: return shortQty;
    case 7: return lockQty;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: strategyId = (java.lang.Integer)value$; break;
    case 1: clientId = (java.lang.Integer)value$; break;
    case 2: accountId = (java.lang.Integer)value$; break;
    case 3: instrumentId = (java.lang.Integer)value$; break;
    case 4: currentQty = (java.lang.Integer)value$; break;
    case 5: tradableQty = (java.lang.Integer)value$; break;
    case 6: shortQty = (java.lang.Integer)value$; break;
    case 7: lockQty = (java.lang.Integer)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'strategyId' field.
   * @return The value of the 'strategyId' field.
   */
  public java.lang.Integer getStrategyId() {
    return strategyId;
  }

  /**
   * Sets the value of the 'strategyId' field.
   * @param value the value to set.
   */
  public com.kafang.atgo.memory.avro.record.Position setStrategyId(java.lang.Integer value) {
    this.strategyId = value;
	return this;
  }

  /**
   * Gets the value of the 'clientId' field.
   * @return The value of the 'clientId' field.
   */
  public java.lang.Integer getClientId() {
    return clientId;
  }

  /**
   * Sets the value of the 'clientId' field.
   * @param value the value to set.
   */
  public com.kafang.atgo.memory.avro.record.Position setClientId(java.lang.Integer value) {
    this.clientId = value;
	return this;
  }

  /**
   * Gets the value of the 'accountId' field.
   * @return The value of the 'accountId' field.
   */
  public java.lang.Integer getAccountId() {
    return accountId;
  }

  /**
   * Sets the value of the 'accountId' field.
   * @param value the value to set.
   */
  public com.kafang.atgo.memory.avro.record.Position setAccountId(java.lang.Integer value) {
    this.accountId = value;
	return this;
  }

  /**
   * Gets the value of the 'instrumentId' field.
   * @return The value of the 'instrumentId' field.
   */
  public java.lang.Integer getInstrumentId() {
    return instrumentId;
  }

  /**
   * Sets the value of the 'instrumentId' field.
   * @param value the value to set.
   */
  public com.kafang.atgo.memory.avro.record.Position setInstrumentId(java.lang.Integer value) {
    this.instrumentId = value;
	return this;
  }

  /**
   * Gets the value of the 'currentQty' field.
   * @return The value of the 'currentQty' field.
   */
  public java.lang.Integer getCurrentQty() {
    return currentQty;
  }

  /**
   * Sets the value of the 'currentQty' field.
   * @param value the value to set.
   */
  public com.kafang.atgo.memory.avro.record.Position setCurrentQty(java.lang.Integer value) {
    this.currentQty = value;
	return this;
  }

  /**
   * Gets the value of the 'tradableQty' field.
   * @return The value of the 'tradableQty' field.
   */
  public java.lang.Integer getTradableQty() {
    return tradableQty;
  }

  /**
   * Sets the value of the 'tradableQty' field.
   * @param value the value to set.
   */
  public com.kafang.atgo.memory.avro.record.Position setTradableQty(java.lang.Integer value) {
    this.tradableQty = value;
	return this;
  }

  /**
   * Gets the value of the 'shortQty' field.
   * @return The value of the 'shortQty' field.
   */
  public java.lang.Integer getShortQty() {
    return shortQty;
  }

  /**
   * Sets the value of the 'shortQty' field.
   * @param value the value to set.
   */
  public com.kafang.atgo.memory.avro.record.Position setShortQty(java.lang.Integer value) {
    this.shortQty = value;
	return this;
  }

  /**
   * Gets the value of the 'lockQty' field.
   * @return The value of the 'lockQty' field.
   */
  public java.lang.Integer getLockQty() {
    return lockQty;
  }

  /**
   * Sets the value of the 'lockQty' field.
   * @param value the value to set.
   */
  public com.kafang.atgo.memory.avro.record.Position setLockQty(java.lang.Integer value) {
    this.lockQty = value;
	return this;
  }

  /**
   * Creates a new Position RecordBuilder.
   * @return A new Position RecordBuilder
   */
  public static com.kafang.atgo.memory.avro.record.Position.Builder newBuilder() {
    return new com.kafang.atgo.memory.avro.record.Position.Builder();
  }

  /**
   * Creates a new Position RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Position RecordBuilder
   */
  public static com.kafang.atgo.memory.avro.record.Position.Builder newBuilder(com.kafang.atgo.memory.avro.record.Position.Builder other) {
    return new com.kafang.atgo.memory.avro.record.Position.Builder(other);
  }

  /**
   * Creates a new Position RecordBuilder by copying an existing Position instance.
   * @param other The existing instance to copy.
   * @return A new Position RecordBuilder
   */
  public static com.kafang.atgo.memory.avro.record.Position.Builder newBuilder(com.kafang.atgo.memory.avro.record.Position other) {
    return new com.kafang.atgo.memory.avro.record.Position.Builder(other);
  }

  /**
   * RecordBuilder for Position instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Position>
    implements org.apache.avro.data.RecordBuilder<Position> {

    private int strategyId;
    private int clientId;
    private int accountId;
    private int instrumentId;
    private int currentQty;
    private int tradableQty;
    private int shortQty;
    private int lockQty;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.kafang.atgo.memory.avro.record.Position.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.strategyId)) {
        this.strategyId = data().deepCopy(fields()[0].schema(), other.strategyId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.clientId)) {
        this.clientId = data().deepCopy(fields()[1].schema(), other.clientId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.accountId)) {
        this.accountId = data().deepCopy(fields()[2].schema(), other.accountId);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.instrumentId)) {
        this.instrumentId = data().deepCopy(fields()[3].schema(), other.instrumentId);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.currentQty)) {
        this.currentQty = data().deepCopy(fields()[4].schema(), other.currentQty);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.tradableQty)) {
        this.tradableQty = data().deepCopy(fields()[5].schema(), other.tradableQty);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.shortQty)) {
        this.shortQty = data().deepCopy(fields()[6].schema(), other.shortQty);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.lockQty)) {
        this.lockQty = data().deepCopy(fields()[7].schema(), other.lockQty);
        fieldSetFlags()[7] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing Position instance
     * @param other The existing instance to copy.
     */
    private Builder(com.kafang.atgo.memory.avro.record.Position other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.strategyId)) {
        this.strategyId = data().deepCopy(fields()[0].schema(), other.strategyId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.clientId)) {
        this.clientId = data().deepCopy(fields()[1].schema(), other.clientId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.accountId)) {
        this.accountId = data().deepCopy(fields()[2].schema(), other.accountId);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.instrumentId)) {
        this.instrumentId = data().deepCopy(fields()[3].schema(), other.instrumentId);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.currentQty)) {
        this.currentQty = data().deepCopy(fields()[4].schema(), other.currentQty);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.tradableQty)) {
        this.tradableQty = data().deepCopy(fields()[5].schema(), other.tradableQty);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.shortQty)) {
        this.shortQty = data().deepCopy(fields()[6].schema(), other.shortQty);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.lockQty)) {
        this.lockQty = data().deepCopy(fields()[7].schema(), other.lockQty);
        fieldSetFlags()[7] = true;
      }
    }

    /**
      * Gets the value of the 'strategyId' field.
      * @return The value.
      */
    public java.lang.Integer getStrategyId() {
      return strategyId;
    }

    /**
      * Sets the value of the 'strategyId' field.
      * @param value The value of 'strategyId'.
      * @return This builder.
      */
    public com.kafang.atgo.memory.avro.record.Position.Builder setStrategyId(int value) {
      validate(fields()[0], value);
      this.strategyId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'strategyId' field has been set.
      * @return True if the 'strategyId' field has been set, false otherwise.
      */
    public boolean hasStrategyId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'strategyId' field.
      * @return This builder.
      */
    public com.kafang.atgo.memory.avro.record.Position.Builder clearStrategyId() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'clientId' field.
      * @return The value.
      */
    public java.lang.Integer getClientId() {
      return clientId;
    }

    /**
      * Sets the value of the 'clientId' field.
      * @param value The value of 'clientId'.
      * @return This builder.
      */
    public com.kafang.atgo.memory.avro.record.Position.Builder setClientId(int value) {
      validate(fields()[1], value);
      this.clientId = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'clientId' field has been set.
      * @return True if the 'clientId' field has been set, false otherwise.
      */
    public boolean hasClientId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'clientId' field.
      * @return This builder.
      */
    public com.kafang.atgo.memory.avro.record.Position.Builder clearClientId() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'accountId' field.
      * @return The value.
      */
    public java.lang.Integer getAccountId() {
      return accountId;
    }

    /**
      * Sets the value of the 'accountId' field.
      * @param value The value of 'accountId'.
      * @return This builder.
      */
    public com.kafang.atgo.memory.avro.record.Position.Builder setAccountId(int value) {
      validate(fields()[2], value);
      this.accountId = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'accountId' field has been set.
      * @return True if the 'accountId' field has been set, false otherwise.
      */
    public boolean hasAccountId() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'accountId' field.
      * @return This builder.
      */
    public com.kafang.atgo.memory.avro.record.Position.Builder clearAccountId() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'instrumentId' field.
      * @return The value.
      */
    public java.lang.Integer getInstrumentId() {
      return instrumentId;
    }

    /**
      * Sets the value of the 'instrumentId' field.
      * @param value The value of 'instrumentId'.
      * @return This builder.
      */
    public com.kafang.atgo.memory.avro.record.Position.Builder setInstrumentId(int value) {
      validate(fields()[3], value);
      this.instrumentId = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'instrumentId' field has been set.
      * @return True if the 'instrumentId' field has been set, false otherwise.
      */
    public boolean hasInstrumentId() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'instrumentId' field.
      * @return This builder.
      */
    public com.kafang.atgo.memory.avro.record.Position.Builder clearInstrumentId() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'currentQty' field.
      * @return The value.
      */
    public java.lang.Integer getCurrentQty() {
      return currentQty;
    }

    /**
      * Sets the value of the 'currentQty' field.
      * @param value The value of 'currentQty'.
      * @return This builder.
      */
    public com.kafang.atgo.memory.avro.record.Position.Builder setCurrentQty(int value) {
      validate(fields()[4], value);
      this.currentQty = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'currentQty' field has been set.
      * @return True if the 'currentQty' field has been set, false otherwise.
      */
    public boolean hasCurrentQty() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'currentQty' field.
      * @return This builder.
      */
    public com.kafang.atgo.memory.avro.record.Position.Builder clearCurrentQty() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'tradableQty' field.
      * @return The value.
      */
    public java.lang.Integer getTradableQty() {
      return tradableQty;
    }

    /**
      * Sets the value of the 'tradableQty' field.
      * @param value The value of 'tradableQty'.
      * @return This builder.
      */
    public com.kafang.atgo.memory.avro.record.Position.Builder setTradableQty(int value) {
      validate(fields()[5], value);
      this.tradableQty = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'tradableQty' field has been set.
      * @return True if the 'tradableQty' field has been set, false otherwise.
      */
    public boolean hasTradableQty() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'tradableQty' field.
      * @return This builder.
      */
    public com.kafang.atgo.memory.avro.record.Position.Builder clearTradableQty() {
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'shortQty' field.
      * @return The value.
      */
    public java.lang.Integer getShortQty() {
      return shortQty;
    }

    /**
      * Sets the value of the 'shortQty' field.
      * @param value The value of 'shortQty'.
      * @return This builder.
      */
    public com.kafang.atgo.memory.avro.record.Position.Builder setShortQty(int value) {
      validate(fields()[6], value);
      this.shortQty = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'shortQty' field has been set.
      * @return True if the 'shortQty' field has been set, false otherwise.
      */
    public boolean hasShortQty() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'shortQty' field.
      * @return This builder.
      */
    public com.kafang.atgo.memory.avro.record.Position.Builder clearShortQty() {
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'lockQty' field.
      * @return The value.
      */
    public java.lang.Integer getLockQty() {
      return lockQty;
    }

    /**
      * Sets the value of the 'lockQty' field.
      * @param value The value of 'lockQty'.
      * @return This builder.
      */
    public com.kafang.atgo.memory.avro.record.Position.Builder setLockQty(int value) {
      validate(fields()[7], value);
      this.lockQty = value;
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'lockQty' field has been set.
      * @return True if the 'lockQty' field has been set, false otherwise.
      */
    public boolean hasLockQty() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'lockQty' field.
      * @return This builder.
      */
    public com.kafang.atgo.memory.avro.record.Position.Builder clearLockQty() {
      fieldSetFlags()[7] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Position build() {
      try {
        Position record = new Position();
        record.strategyId = fieldSetFlags()[0] ? this.strategyId : (java.lang.Integer) defaultValue(fields()[0]);
        record.clientId = fieldSetFlags()[1] ? this.clientId : (java.lang.Integer) defaultValue(fields()[1]);
        record.accountId = fieldSetFlags()[2] ? this.accountId : (java.lang.Integer) defaultValue(fields()[2]);
        record.instrumentId = fieldSetFlags()[3] ? this.instrumentId : (java.lang.Integer) defaultValue(fields()[3]);
        record.currentQty = fieldSetFlags()[4] ? this.currentQty : (java.lang.Integer) defaultValue(fields()[4]);
        record.tradableQty = fieldSetFlags()[5] ? this.tradableQty : (java.lang.Integer) defaultValue(fields()[5]);
        record.shortQty = fieldSetFlags()[6] ? this.shortQty : (java.lang.Integer) defaultValue(fields()[6]);
        record.lockQty = fieldSetFlags()[7] ? this.lockQty : (java.lang.Integer) defaultValue(fields()[7]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Position>
    WRITER$ = (org.apache.avro.io.DatumWriter<Position>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Position>
    READER$ = (org.apache.avro.io.DatumReader<Position>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
