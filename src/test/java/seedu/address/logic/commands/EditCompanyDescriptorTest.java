package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.DESC_APPLE;
import static seedu.address.logic.commands.CommandTestUtil.DESC_BOEING;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOEING;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOEING;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOEING;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOEING;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_PENDING_APPLICATION;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.EditCommand.EditCompanyDescriptor;
import seedu.address.testutil.EditCompanyDescriptorBuilder;

public class EditCompanyDescriptorTest {

    @Test
    public void equals() {
        // same values -> returns true
        EditCompanyDescriptor descriptorWithSameValues = new EditCompanyDescriptor(DESC_APPLE);
        assertTrue(DESC_APPLE.equals(descriptorWithSameValues));

        // same object -> returns true
        assertTrue(DESC_APPLE.equals(DESC_APPLE));

        // null -> returns false
        assertFalse(DESC_APPLE.equals(null));

        // different types -> returns false
        assertFalse(DESC_APPLE.equals(5));

        // different values -> returns false
        assertFalse(DESC_APPLE.equals(DESC_BOEING));

        // different name -> returns false
        EditCompanyDescriptor editedAmy = new EditCompanyDescriptorBuilder(DESC_APPLE).withName(VALID_NAME_BOEING).build();
        assertFalse(DESC_APPLE.equals(editedAmy));

        // different phone -> returns false
        editedAmy = new EditCompanyDescriptorBuilder(DESC_APPLE).withPhone(VALID_PHONE_BOEING).build();
        assertFalse(DESC_APPLE.equals(editedAmy));

        // different email -> returns false
        editedAmy = new EditCompanyDescriptorBuilder(DESC_APPLE).withEmail(VALID_EMAIL_BOEING).build();
        assertFalse(DESC_APPLE.equals(editedAmy));

        // different address -> returns false
        editedAmy = new EditCompanyDescriptorBuilder(DESC_APPLE).withAddress(VALID_ADDRESS_BOEING).build();
        assertFalse(DESC_APPLE.equals(editedAmy));

        // different tags -> returns false
        editedAmy = new EditCompanyDescriptorBuilder(DESC_APPLE).withTags(VALID_TAG_PENDING_APPLICATION).build();
        assertFalse(DESC_APPLE.equals(editedAmy));
    }

    @Test
    public void toStringMethod() {
        EditCompanyDescriptor editCompanyDescriptor = new EditCompanyDescriptor();
        String expected = EditCompanyDescriptor.class.getCanonicalName() + "{name="
                + editCompanyDescriptor.getName().orElse(null) + ", phone="
                + editCompanyDescriptor.getPhone().orElse(null) + ", email="
                + editCompanyDescriptor.getEmail().orElse(null) + ", address="
                + editCompanyDescriptor.getAddress().orElse(null) + ", tags="
                + editCompanyDescriptor.getTags().orElse(null) + "}";
        assertEquals(expected, editCompanyDescriptor.toString());
    }
}
