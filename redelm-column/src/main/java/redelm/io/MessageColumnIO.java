package redelm.io;


import java.util.Arrays;
import java.util.List;

import redelm.column.ColumnsStore;
import redelm.data.GroupFactory;
import redelm.schema.MessageType;


public class MessageColumnIO extends GroupColumnIO {
//  private static final Logger logger = Logger.getLogger(MessageColumnIO.class.getName());

  private final GroupFactory groupFactory;
  private List<PrimitiveColumnIO> leaves;

  MessageColumnIO(MessageType messageType, GroupFactory groupFactory) {
    super(messageType, null);
    this.groupFactory = groupFactory;
  }

  public List<String[]> getColumnNames() {
    return super.getColumnNames();
  }

  public RecordReader getRecordReader() {
    return new RecordReader(this, leaves, groupFactory);
  }

  public RecordWriter getRecordWriter() {
    return new RecordWriter(this);
  }

  void setLevels(ColumnsStore columns) {
    setLevels(0, 0, new String[0], Arrays.<ColumnIO>asList(this), Arrays.<ColumnIO>asList(this), columns);
  }

  void setLeaves(List<PrimitiveColumnIO> leaves) {
    this.leaves = leaves;
  }

  public List<PrimitiveColumnIO> getLeaves() {
    return this.leaves;
  }

}
