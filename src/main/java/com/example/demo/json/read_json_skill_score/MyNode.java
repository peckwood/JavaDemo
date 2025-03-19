package com.example.demo.json.read_json_skill_score;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class MyNode {
    public final static String INDENT_STRING = "|-- ";
    private String id;
    private String parentId;
    private String treeName;
    private String weight;
    private String value;
    private Integer nodeLevel;
    private List<MyNode> children;

    public MyNode() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getTreeName() {
        return treeName;
    }

    public void setTreeName(String treeName) {
        this.treeName = treeName;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getNodeLevel() {
        return nodeLevel;
    }

    public void setNodeLevel(Integer nodeLevel) {
        this.nodeLevel = nodeLevel;
    }

    public List<MyNode> getChildren() {
        return children;
    }

    public void setChildren(List<MyNode> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        /*StringBuilder sb = new StringBuilder().append("MyNode{treeName='").append(treeName).append('\'').append(", value='").append(value).append('\'').append('}');
        if(getChildren() != null) {
            for (MyNode child : getChildren()) {
                sb.append(child.getToString());
            }
        }
        return sb.toString();*/
        return getCurrentToString(INDENT_STRING);
    }

    public String getCurrentToString(String indent){
        StringBuilder sb =  new StringBuilder();
        String toString = "\n" + indent  + ("MyNode{treeName='" + treeName + '\'') + (StringUtils.isNotBlank(value) ? (", value='" + value + '\'') : "") + '}';

        String childIndentString = "    " + indent;
        if(getChildren() != null) {
            for (MyNode child : getChildren()) {
                toString += child.getCurrentToString(childIndentString);
            }
        }
        return toString;
    }
}
