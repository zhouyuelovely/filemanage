package filemanage.systemmanage.pojo;

import java.util.Date;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

public class MessageNotification {
	private String messageId;// 消息主键
	private Date messageTime;// 消息时间
	private String messageType;// 消息类型,一般消息，借阅消息，预警消息
	private String messageContent;// 消息内容
	private String messageCreator;// 消息人
	private String messageStart;// 消息状态 1：未读 2：已读

	public MessageNotification() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MessageNotification(String messageId, Date messageTime, String messageType, String messageContent,
			String messageCreator, String messageStart) {
		super();
		this.messageId = messageId;
		this.messageTime = messageTime;
		this.messageType = messageType;
		this.messageContent = messageContent;
		this.messageCreator = messageCreator;
		this.messageStart = messageStart;
	}

	public MessageNotification(String messageType, String messageContent, String messageCreator) {
		super();
		this.messageType = messageType;
		this.messageContent = messageContent;
		this.messageCreator = messageCreator;
	}

	@Override
	public String toString() {
		return "MessageNotification [messageId=" + messageId + ", messageTime=" + messageTime + ", messageType="
				+ messageType + ", messageContent=" + messageContent + ", messageCreator=" + messageCreator
				+ ", messageStart=" + messageStart + "]";
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public Date getMessageTime() {
		return messageTime;
	}

	public void setMessageTime(Date messageTime) {
		this.messageTime = messageTime;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public String getMessageCreator() {
		return messageCreator;
	}

	public void setMessageCreator(String messageCreator) {
		this.messageCreator = messageCreator;
	}

	public String getMessageStart() {
		return messageStart;
	}

	public void setMessageStart(String messageStart) {
		this.messageStart = messageStart;
	}

}
