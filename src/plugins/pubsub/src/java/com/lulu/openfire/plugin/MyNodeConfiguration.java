package com.lulu.openfire.plugin;

import org.jivesoftware.openfire.pubsub.CollectionNode;
import org.jivesoftware.openfire.pubsub.CollectionNode.LeafNodeAssociationPolicy;
import org.jivesoftware.openfire.pubsub.Node;
import org.jivesoftware.openfire.pubsub.Node.ItemReplyPolicy;
import org.jivesoftware.openfire.pubsub.models.AccessModel;
import org.jivesoftware.openfire.pubsub.models.PublisherModel;
import org.jivesoftware.util.LocaleUtils;
import org.xmpp.forms.DataForm;
import org.xmpp.forms.DataForm.Type;
import org.xmpp.forms.FormField;

public class MyNodeConfiguration
{
  private boolean leaf;
  private boolean deliverPayloads;
  private int maxPayloadSize;
  private boolean persistPublishedItems;
  private int maxPublishedItems;
  private boolean notifyConfigChanges;
  private boolean notifyDelete;
  private boolean notifyRetract;
  private boolean presenceBasedDelivery;
  private boolean sendItemSubscribe = false;
  private PublisherModel publisherModel = PublisherModel.open;
  private boolean subscriptionEnabled;
  private AccessModel accessModel = AccessModel.open;
  private String language = "";
  private Node.ItemReplyPolicy replyPolicy = Node.ItemReplyPolicy.owner;
  private CollectionNode.LeafNodeAssociationPolicy associationPolicy = CollectionNode.LeafNodeAssociationPolicy.all;
  private int maxLeafNodes = -1;
  
  public MyNodeConfiguration(boolean isLeafType)
  {
    this.leaf = isLeafType;
  }
  
  public boolean isLeaf()
  {
    return this.leaf;
  }
  
  public boolean isDeliverPayloads()
  {
    return this.deliverPayloads;
  }
  
  public int getMaxPayloadSize()
  {
    return this.maxPayloadSize;
  }
  
  public boolean isPersistPublishedItems()
  {
    return this.persistPublishedItems;
  }
  
  public int getMaxPublishedItems()
  {
    return this.maxPublishedItems;
  }
  
  public boolean isNotifyConfigChanges()
  {
    return this.notifyConfigChanges;
  }
  
  public boolean isNotifyDelete()
  {
    return this.notifyDelete;
  }
  
  public boolean isNotifyRetract()
  {
    return this.notifyRetract;
  }
  
  public boolean isPresenceBasedDelivery()
  {
    return this.presenceBasedDelivery;
  }
  
  public boolean isSendItemSubscribe()
  {
    return this.sendItemSubscribe;
  }
  
  public PublisherModel getPublisherModel()
  {
    return this.publisherModel;
  }
  
  public boolean isSubscriptionEnabled()
  {
    return this.subscriptionEnabled;
  }
  
  public AccessModel getAccessModel()
  {
    return this.accessModel;
  }
  
  public String getLanguage()
  {
    return this.language;
  }
  
  public Node.ItemReplyPolicy getReplyPolicy()
  {
    return this.replyPolicy;
  }
  
  public CollectionNode.LeafNodeAssociationPolicy getAssociationPolicy()
  {
    return this.associationPolicy;
  }
  
  public int getMaxLeafNodes()
  {
    return this.maxLeafNodes;
  }
  
  public void setDeliverPayloads(boolean deliverPayloads)
  {
    this.deliverPayloads = deliverPayloads;
  }
  
  public void setMaxPayloadSize(int maxPayloadSize)
  {
    this.maxPayloadSize = maxPayloadSize;
  }
  
  public void setPersistPublishedItems(boolean persistPublishedItems)
  {
    this.persistPublishedItems = persistPublishedItems;
  }
  
  public void setMaxPublishedItems(int maxPublishedItems)
  {
    this.maxPublishedItems = maxPublishedItems;
  }
  
  public void setNotifyConfigChanges(boolean notifyConfigChanges)
  {
    this.notifyConfigChanges = notifyConfigChanges;
  }
  
  public void setNotifyDelete(boolean notifyDelete)
  {
    this.notifyDelete = notifyDelete;
  }
  
  public void setNotifyRetract(boolean notifyRetract)
  {
    this.notifyRetract = notifyRetract;
  }
  
  public void setPresenceBasedDelivery(boolean presenceBasedDelivery)
  {
    this.presenceBasedDelivery = presenceBasedDelivery;
  }
  
  public void setSendItemSubscribe(boolean sendItemSubscribe)
  {
    this.sendItemSubscribe = sendItemSubscribe;
  }
  
  public void setPublisherModel(PublisherModel publisherModel)
  {
    this.publisherModel = publisherModel;
  }
  
  public void setSubscriptionEnabled(boolean subscriptionEnabled)
  {
    this.subscriptionEnabled = subscriptionEnabled;
  }
  
  public void setAccessModel(AccessModel accessModel)
  {
    this.accessModel = accessModel;
  }
  
  public void setLanguage(String language)
  {
    this.language = language;
  }
  
  public void setReplyPolicy(Node.ItemReplyPolicy replyPolicy)
  {
    this.replyPolicy = replyPolicy;
  }
  
  public void setAssociationPolicy(CollectionNode.LeafNodeAssociationPolicy associationPolicy)
  {
    this.associationPolicy = associationPolicy;
  }
  
  public void setMaxLeafNodes(int maxLeafNodes)
  {
    this.maxLeafNodes = maxLeafNodes;
  }
  
  public DataForm getConfigurationForm()
  {
    DataForm form = new DataForm(DataForm.Type.submit);
    form.setTitle(LocaleUtils.getLocalizedString("pubsub.form.default.title"));
    form.addInstruction(LocaleUtils.getLocalizedString("pubsub.form.default.instruction"));
    
    FormField formField = form.addField();
    formField.setVariable("FORM_TYPE");
    formField.setType(FormField.Type.hidden);
    formField.addValue("http://jabber.org/protocol/pubsub#node_config");
    
    formField = form.addField();
    formField.setVariable("pubsub#subscribe");
    formField.setType(FormField.Type.boolean_type);
    formField.setLabel(LocaleUtils.getLocalizedString("pubsub.form.conf.subscribe"));
    formField.addValue(Boolean.valueOf(this.subscriptionEnabled));
    
    formField = form.addField();
    formField.setVariable("pubsub#deliver_payloads");
    formField.setType(FormField.Type.boolean_type);
    formField.setLabel(LocaleUtils.getLocalizedString("pubsub.form.conf.deliver_payloads"));
    formField.addValue(Boolean.valueOf(this.deliverPayloads));
    
    formField = form.addField();
    formField.setVariable("pubsub#notify_config");
    formField.setType(FormField.Type.boolean_type);
    formField.setLabel(LocaleUtils.getLocalizedString("pubsub.form.conf.notify_config"));
    formField.addValue(Boolean.valueOf(this.notifyConfigChanges));
    
    formField = form.addField();
    formField.setVariable("pubsub#notify_delete");
    formField.setType(FormField.Type.boolean_type);
    formField.setLabel(LocaleUtils.getLocalizedString("pubsub.form.conf.notify_delete"));
    formField.addValue(Boolean.valueOf(this.notifyDelete));
    
    formField = form.addField();
    formField.setVariable("pubsub#notify_retract");
    formField.setType(FormField.Type.boolean_type);
    formField.setLabel(LocaleUtils.getLocalizedString("pubsub.form.conf.notify_retract"));
    formField.addValue(Boolean.valueOf(this.notifyRetract));
    
    formField = form.addField();
    formField.setVariable("pubsub#presence_based_delivery");
    formField.setType(FormField.Type.boolean_type);
    formField.setLabel(LocaleUtils.getLocalizedString("pubsub.form.conf.presence_based"));
    formField.addValue(Boolean.valueOf(this.presenceBasedDelivery));
    if (this.leaf)
    {
      formField = form.addField();
      formField.setVariable("pubsub#send_item_subscribe");
      formField.setType(FormField.Type.boolean_type);
      formField.setLabel(
        LocaleUtils.getLocalizedString("pubsub.form.conf.send_item_subscribe"));
      formField.addValue(Boolean.valueOf(this.sendItemSubscribe));
      
      formField = form.addField();
      formField.setVariable("pubsub#persist_items");
      formField.setType(FormField.Type.boolean_type);
      formField.setLabel(LocaleUtils.getLocalizedString("pubsub.form.conf.persist_items"));
      formField.addValue(Boolean.valueOf(this.persistPublishedItems));
      
      formField = form.addField();
      formField.setVariable("pubsub#max_items");
      formField.setType(FormField.Type.text_single);
      formField.setLabel(LocaleUtils.getLocalizedString("pubsub.form.conf.max_items"));
      formField.addValue(Integer.valueOf(this.maxPublishedItems));
      
      formField = form.addField();
      formField.setVariable("pubsub#max_payload_size");
      formField.setType(FormField.Type.text_single);
      formField.setLabel(LocaleUtils.getLocalizedString("pubsub.form.conf.max_payload_size"));
      formField.addValue(Integer.valueOf(this.maxPayloadSize));
    }
    formField = form.addField();
    formField.setVariable("pubsub#access_model");
    formField.setType(FormField.Type.list_single);
    formField.setLabel(LocaleUtils.getLocalizedString("pubsub.form.conf.access_model"));
    formField.addOption(null, AccessModel.authorize.getName());
    formField.addOption(null, AccessModel.open.getName());
    formField.addOption(null, AccessModel.presence.getName());
    formField.addOption(null, AccessModel.roster.getName());
    formField.addOption(null, AccessModel.whitelist.getName());
    formField.addValue(this.accessModel.getName());
    
    formField = form.addField();
    formField.setVariable("pubsub#publish_model");
    formField.setType(FormField.Type.list_single);
    formField.setLabel(LocaleUtils.getLocalizedString("pubsub.form.conf.publish_model"));
    formField.addOption(null, PublisherModel.publishers.getName());
    formField.addOption(null, PublisherModel.subscribers.getName());
    formField.addOption(null, PublisherModel.open.getName());
    formField.addValue(this.publisherModel.getName());
    
    formField = form.addField();
    formField.setVariable("pubsub#language");
    formField.setType(FormField.Type.text_single);
    formField.setLabel(LocaleUtils.getLocalizedString("pubsub.form.conf.language"));
    formField.addValue(this.language);
    
    formField = form.addField();
    formField.setVariable("pubsub#itemreply");
    formField.setType(FormField.Type.list_single);
    formField.setLabel(LocaleUtils.getLocalizedString("pubsub.form.conf.itemreply"));
    if (this.replyPolicy != null) {
      formField.addValue(this.replyPolicy.name());
    }
    if (!this.leaf)
    {
      formField = form.addField();
      formField.setVariable("pubsub#leaf_node_association_policy");
      formField.setType(FormField.Type.list_single);
      formField.setLabel(LocaleUtils.getLocalizedString("pubsub.form.conf.leaf_node_association"));
      formField.addOption(null, CollectionNode.LeafNodeAssociationPolicy.all.name());
      formField.addOption(null, CollectionNode.LeafNodeAssociationPolicy.owners.name());
      formField.addOption(null, CollectionNode.LeafNodeAssociationPolicy.whitelist.name());
      formField.addValue(this.associationPolicy.name());
      
      formField = form.addField();
      formField.setVariable("pubsub#leaf_nodes_max");
      formField.setType(FormField.Type.text_single);
      formField.setLabel(LocaleUtils.getLocalizedString("pubsub.form.conf.leaf_nodes_max"));
      formField.addValue(Integer.valueOf(this.maxLeafNodes));
    }
    return form;
  }
}
