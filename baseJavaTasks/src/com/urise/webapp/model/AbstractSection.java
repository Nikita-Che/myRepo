package com.urise.webapp.model;

public class AbstractSection {
    OrganizationSection organizationSection;
    TextSection textSection;
    ListSection listSection;

    public OrganizationSection getOrganizationSection() {
        return organizationSection;
    }

    public void setOrganizationSection(OrganizationSection organizationSection) {
        this.organizationSection = organizationSection;
    }

    public TextSection getTextSection() {
        return textSection;
    }

    public void setTextSection(TextSection textSection) {
        this.textSection = textSection;
    }

    public ListSection getListSection() {
        return listSection;
    }

    public void setListSection(ListSection listSection) {
        this.listSection = listSection;
    }

    @Override
    public String toString() {
        return "AbstractSection{" +
                "organizationSection=" + organizationSection +
                ", textSection=" + textSection +
                ", listSection=" + listSection +
                '}';
    }
}
