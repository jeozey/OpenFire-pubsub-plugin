package org.jivesoftware.openfire.pubsub;

import org.xmpp.packet.JID;

public class MyLeafNode
  extends LeafNode
{
  public MyLeafNode(PubSubService service, CollectionNode parentNode, String nodeID, JID creator)
  {
    super(service, parentNode, nodeID, creator);
  }
  
  public void setDescription(String description)
  {
    this.description = description;
  }
  public void setName(String name)
  {
    this.name = name;
  }
  
}
