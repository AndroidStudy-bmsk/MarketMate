package org.bmsk.marketmate.model

class Empty : ListItem {
    override val viewType: ViewType
        get() = ViewType.EMPTY
}