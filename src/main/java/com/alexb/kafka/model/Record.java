/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.alexb.kafka.model;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Record extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Record\",\"namespace\":\"com.alexb.kafka.model\",\"fields\":[{\"name\":\"time\",\"type\":\"long\"},{\"name\":\"message\",\"type\":{\"type\":\"record\",\"name\":\"Message\",\"fields\":[{\"name\":\"id\",\"type\":\"string\"},{\"name\":\"message\",\"type\":\"string\"}]}},{\"name\":\"tags\",\"type\":{\"type\":\"array\",\"items\":\"string\"},\"default\":[]},{\"name\":\"status\",\"type\":{\"type\":\"enum\",\"name\":\"Status\",\"symbols\":[\"ACTIVE\",\"INACTIVE\"]}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public long time;
  @Deprecated public com.alexb.kafka.model.Message message;
  @Deprecated public java.util.List<java.lang.CharSequence> tags;
  @Deprecated public com.alexb.kafka.model.Status status;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public Record() {}

  /**
   * All-args constructor.
   */
  public Record(java.lang.Long time, com.alexb.kafka.model.Message message, java.util.List<java.lang.CharSequence> tags, com.alexb.kafka.model.Status status) {
    this.time = time;
    this.message = message;
    this.tags = tags;
    this.status = status;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return time;
    case 1: return message;
    case 2: return tags;
    case 3: return status;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: time = (java.lang.Long)value$; break;
    case 1: message = (com.alexb.kafka.model.Message)value$; break;
    case 2: tags = (java.util.List<java.lang.CharSequence>)value$; break;
    case 3: status = (com.alexb.kafka.model.Status)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'time' field.
   */
  public java.lang.Long getTime() {
    return time;
  }

  /**
   * Sets the value of the 'time' field.
   * @param value the value to set.
   */
  public void setTime(java.lang.Long value) {
    this.time = value;
  }

  /**
   * Gets the value of the 'message' field.
   */
  public com.alexb.kafka.model.Message getMessage() {
    return message;
  }

  /**
   * Sets the value of the 'message' field.
   * @param value the value to set.
   */
  public void setMessage(com.alexb.kafka.model.Message value) {
    this.message = value;
  }

  /**
   * Gets the value of the 'tags' field.
   */
  public java.util.List<java.lang.CharSequence> getTags() {
    return tags;
  }

  /**
   * Sets the value of the 'tags' field.
   * @param value the value to set.
   */
  public void setTags(java.util.List<java.lang.CharSequence> value) {
    this.tags = value;
  }

  /**
   * Gets the value of the 'status' field.
   */
  public com.alexb.kafka.model.Status getStatus() {
    return status;
  }

  /**
   * Sets the value of the 'status' field.
   * @param value the value to set.
   */
  public void setStatus(com.alexb.kafka.model.Status value) {
    this.status = value;
  }

  /** Creates a new Record RecordBuilder */
  public static com.alexb.kafka.model.Record.Builder newBuilder() {
    return new com.alexb.kafka.model.Record.Builder();
  }
  
  /** Creates a new Record RecordBuilder by copying an existing Builder */
  public static com.alexb.kafka.model.Record.Builder newBuilder(com.alexb.kafka.model.Record.Builder other) {
    return new com.alexb.kafka.model.Record.Builder(other);
  }
  
  /** Creates a new Record RecordBuilder by copying an existing Record instance */
  public static com.alexb.kafka.model.Record.Builder newBuilder(com.alexb.kafka.model.Record other) {
    return new com.alexb.kafka.model.Record.Builder(other);
  }
  
  /**
   * RecordBuilder for Record instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Record>
    implements org.apache.avro.data.RecordBuilder<Record> {

    private long time;
    private com.alexb.kafka.model.Message message;
    private java.util.List<java.lang.CharSequence> tags;
    private com.alexb.kafka.model.Status status;

    /** Creates a new Builder */
    private Builder() {
      super(com.alexb.kafka.model.Record.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.alexb.kafka.model.Record.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.time)) {
        this.time = data().deepCopy(fields()[0].schema(), other.time);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.message)) {
        this.message = data().deepCopy(fields()[1].schema(), other.message);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.tags)) {
        this.tags = data().deepCopy(fields()[2].schema(), other.tags);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.status)) {
        this.status = data().deepCopy(fields()[3].schema(), other.status);
        fieldSetFlags()[3] = true;
      }
    }
    
    /** Creates a Builder by copying an existing Record instance */
    private Builder(com.alexb.kafka.model.Record other) {
            super(com.alexb.kafka.model.Record.SCHEMA$);
      if (isValidValue(fields()[0], other.time)) {
        this.time = data().deepCopy(fields()[0].schema(), other.time);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.message)) {
        this.message = data().deepCopy(fields()[1].schema(), other.message);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.tags)) {
        this.tags = data().deepCopy(fields()[2].schema(), other.tags);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.status)) {
        this.status = data().deepCopy(fields()[3].schema(), other.status);
        fieldSetFlags()[3] = true;
      }
    }

    /** Gets the value of the 'time' field */
    public java.lang.Long getTime() {
      return time;
    }
    
    /** Sets the value of the 'time' field */
    public com.alexb.kafka.model.Record.Builder setTime(long value) {
      validate(fields()[0], value);
      this.time = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'time' field has been set */
    public boolean hasTime() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'time' field */
    public com.alexb.kafka.model.Record.Builder clearTime() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'message' field */
    public com.alexb.kafka.model.Message getMessage() {
      return message;
    }
    
    /** Sets the value of the 'message' field */
    public com.alexb.kafka.model.Record.Builder setMessage(com.alexb.kafka.model.Message value) {
      validate(fields()[1], value);
      this.message = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'message' field has been set */
    public boolean hasMessage() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'message' field */
    public com.alexb.kafka.model.Record.Builder clearMessage() {
      message = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'tags' field */
    public java.util.List<java.lang.CharSequence> getTags() {
      return tags;
    }
    
    /** Sets the value of the 'tags' field */
    public com.alexb.kafka.model.Record.Builder setTags(java.util.List<java.lang.CharSequence> value) {
      validate(fields()[2], value);
      this.tags = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'tags' field has been set */
    public boolean hasTags() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'tags' field */
    public com.alexb.kafka.model.Record.Builder clearTags() {
      tags = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'status' field */
    public com.alexb.kafka.model.Status getStatus() {
      return status;
    }
    
    /** Sets the value of the 'status' field */
    public com.alexb.kafka.model.Record.Builder setStatus(com.alexb.kafka.model.Status value) {
      validate(fields()[3], value);
      this.status = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'status' field has been set */
    public boolean hasStatus() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'status' field */
    public com.alexb.kafka.model.Record.Builder clearStatus() {
      status = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    public Record build() {
      try {
        Record record = new Record();
        record.time = fieldSetFlags()[0] ? this.time : (java.lang.Long) defaultValue(fields()[0]);
        record.message = fieldSetFlags()[1] ? this.message : (com.alexb.kafka.model.Message) defaultValue(fields()[1]);
        record.tags = fieldSetFlags()[2] ? this.tags : (java.util.List<java.lang.CharSequence>) defaultValue(fields()[2]);
        record.status = fieldSetFlags()[3] ? this.status : (com.alexb.kafka.model.Status) defaultValue(fields()[3]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
