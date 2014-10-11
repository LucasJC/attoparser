/*
 * =============================================================================
 * 
 *   Copyright (c) 2012-2014, The ATTOPARSER team (http://www.attoparser.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package org.attoparser;


import java.util.List;

/*
 * Utility class for char[] operations (mainly matching/comparing).
 *
 * @author Daniel Fernandez
 * @since 2.0.0
 */
final class TextUtil {




    static boolean equals(final boolean caseSensitive, final String text1, final String text2) {

        if (text1 == null) {
            throw new IllegalArgumentException("First text being compared cannot be null");
        }
        if (text2 == null) {
            throw new IllegalArgumentException("Second text being compared cannot be null");
        }

        return (caseSensitive? text1.equals(text2) : text1.equalsIgnoreCase(text2));

    }


    static boolean equals(final boolean caseSensitive, final String text1, final char[] text2) {
        return equals(caseSensitive, text1, 0, text1.length(), text2, 0, text2.length);
    }

    static boolean equals(final boolean caseSensitive, final char[] text1, final char[] text2) {
        return equals(caseSensitive, text1, 0, text1.length, text2, 0, text2.length);
    }



    static boolean equals(
            final boolean caseSensitive,
            final char[] text1, final int text1Offset, final int text1Len,
            final char[] text2, final int text2Offset, final int text2Len) {

        if (text1 == null) {
            throw new IllegalArgumentException("First text buffer being compared cannot be null");
        }
        if (text2 == null) {
            throw new IllegalArgumentException("Second text buffer being compared cannot be null");
        }

        if (text1Len != text2Len) {
            return false;
        }

        if (text1 == text2 && text1Offset == text2Offset && text1Len == text2Len) {
            return true;
        }

        char c1, c2;

        int n = text1Len;
        int i = 0;

        while (n-- != 0) {

            c1 = text1[text1Offset + i];
            c2 = text2[text2Offset + i];

            if (c1 != c2) {

                if (caseSensitive) {
                    return false;
                }

                c1 = Character.toUpperCase(c1);
                c2 = Character.toUpperCase(c2);

                if (c1 != c2) {

                    // We check both upper and lower case because that is how String#equalsIgnoreCase() is defined.
                    // See String#regionMatches(boolean,int,String,int,int)
                    if (Character.toLowerCase(c1) != Character.toLowerCase(c2)) {
                        return false;
                    }

                }

            }

            i++;

        }

        return true;

    }



    static boolean equals(
            final boolean caseSensitive,
            final String text1, final int text1Offset, final int text1Len,
            final char[] text2, final int text2Offset, final int text2Len) {

        if (text1 == null) {
            throw new IllegalArgumentException("First text being compared cannot be null");
        }
        if (text2 == null) {
            throw new IllegalArgumentException("Second text buffer being compared cannot be null");
        }

        if (text1Len != text2Len) {
            return false;
        }

        char c1, c2;

        int n = text1Len;
        int i = 0;

        while (n-- != 0) {

            c1 = text1.charAt(text1Offset + i);
            c2 = text2[text2Offset + i];

            if (c1 != c2) {

                if (caseSensitive) {
                    return false;
                }

                c1 = Character.toUpperCase(c1);
                c2 = Character.toUpperCase(c2);

                if (c1 != c2) {

                    // We check both upper and lower case because that is how String#equalsIgnoreCase() is defined.
                    // See String#regionMatches(boolean,int,String,int,int)
                    if (Character.toLowerCase(c1) != Character.toLowerCase(c2)) {
                        return false;
                    }

                }

            }

            i++;

        }

        return true;

    }



    static boolean equals(
            final boolean caseSensitive,
            final String text1, final int text1Offset, final int text1Len,
            final String text2, final int text2Offset, final int text2Len) {

        if (text1 == null) {
            throw new IllegalArgumentException("First text being compared cannot be null");
        }
        if (text2 == null) {
            throw new IllegalArgumentException("Second text being compared cannot be null");
        }

        if (text1Len != text2Len) {
            return false;
        }

        if (text1 == text2 && text1Offset == text2Offset && text1Len == text2Len) {
            return true;
        }

        char c1, c2;

        int n = text1Len;
        int i = 0;

        while (n-- != 0) {

            c1 = text1.charAt(text1Offset + i);
            c2 = text2.charAt(text2Offset + i);

            if (c1 != c2) {

                if (caseSensitive) {
                    return false;
                }

                c1 = Character.toUpperCase(c1);
                c2 = Character.toUpperCase(c2);

                if (c1 != c2) {

                    // We check both upper and lower case because that is how String#equalsIgnoreCase() is defined.
                    // See String#regionMatches(boolean,int,String,int,int)
                    if (Character.toLowerCase(c1) != Character.toLowerCase(c2)) {
                        return false;
                    }

                }

            }

            i++;

        }

        return true;

    }









    static boolean startsWith(final boolean caseSensitive, final String text, final String prefix) {

        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null");
        }
        if (prefix == null) {
            throw new IllegalArgumentException("Prefix cannot be null");
        }

        return (caseSensitive? text.startsWith(prefix) : startsWith(caseSensitive, text, 0, text.length(), prefix, 0, prefix.length()));

    }


    static boolean startsWith(final boolean caseSensitive, final String text, final char[] prefix) {
        return startsWith(caseSensitive, text, 0, text.length(), prefix, 0, prefix.length);
    }

    static boolean startsWith(final boolean caseSensitive, final char[] text, final char[] prefix) {
        return startsWith(caseSensitive, text, 0, text.length, prefix, 0, prefix.length);
    }



    static boolean startsWith(
            final boolean caseSensitive,
            final char[] text, final int textOffset, final int textLen,
            final char[] prefix, final int prefixOffset, final int prefixLen) {

        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null");
        }
        if (prefix == null) {
            throw new IllegalArgumentException("Prefix cannot be null");
        }

        if (textLen < prefixLen) {
            return false;
        }

        char c1, c2;

        int n = prefixLen;
        int i = 0;

        while (n-- != 0) {

            c1 = text[textOffset + i];
            c2 = prefix[prefixOffset + i];

            if (c1 != c2) {

                if (caseSensitive) {
                    return false;
                }

                c1 = Character.toUpperCase(c1);
                c2 = Character.toUpperCase(c2);

                if (c1 != c2) {

                    // We check both upper and lower case because that is how String#equalsIgnoreCase() is defined.
                    // See String#regionMatches(boolean,int,String,int,int)
                    if (Character.toLowerCase(c1) != Character.toLowerCase(c2)) {
                        return false;
                    }

                }

            }

            i++;

        }

        return true;

    }



    static boolean startsWith(
            final boolean caseSensitive,
            final String text, final int textOffset, final int textLen,
            final char[] prefix, final int prefixOffset, final int prefixLen) {

        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null");
        }
        if (prefix == null) {
            throw new IllegalArgumentException("Prefix cannot be null");
        }

        if (textLen < prefixLen) {
            return false;
        }

        char c1, c2;

        int n = prefixLen;
        int i = 0;

        while (n-- != 0) {

            c1 = text.charAt(textOffset + i);
            c2 = prefix[prefixOffset + i];

            if (c1 != c2) {

                if (caseSensitive) {
                    return false;
                }

                c1 = Character.toUpperCase(c1);
                c2 = Character.toUpperCase(c2);

                if (c1 != c2) {

                    // We check both upper and lower case because that is how String#equalsIgnoreCase() is defined.
                    // See String#regionMatches(boolean,int,String,int,int)
                    if (Character.toLowerCase(c1) != Character.toLowerCase(c2)) {
                        return false;
                    }

                }

            }

            i++;

        }

        return true;

    }



    static boolean startsWith(
            final boolean caseSensitive,
            final char[] text, final int textOffset, final int textLen,
            final String prefix, final int prefixOffset, final int prefixLen) {

        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null");
        }
        if (prefix == null) {
            throw new IllegalArgumentException("Prefix cannot be null");
        }

        if (textLen < prefixLen) {
            return false;
        }

        char c1, c2;

        int n = prefixLen;
        int i = 0;

        while (n-- != 0) {

            c1 = text[textOffset + i];
            c2 = prefix.charAt(prefixOffset + i);

            if (c1 != c2) {

                if (caseSensitive) {
                    return false;
                }

                c1 = Character.toUpperCase(c1);
                c2 = Character.toUpperCase(c2);

                if (c1 != c2) {

                    // We check both upper and lower case because that is how String#equalsIgnoreCase() is defined.
                    // See String#regionMatches(boolean,int,String,int,int)
                    if (Character.toLowerCase(c1) != Character.toLowerCase(c2)) {
                        return false;
                    }

                }

            }

            i++;

        }

        return true;

    }



    static boolean startsWith(
            final boolean caseSensitive,
            final String text, final int textOffset, final int textLen,
            final String prefix, final int prefixOffset, final int prefixLen) {

        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null");
        }
        if (prefix == null) {
            throw new IllegalArgumentException("Prefix cannot be null");
        }

        if (textLen < prefixLen) {
            return false;
        }

        char c1, c2;

        int n = prefixLen;
        int i = 0;

        while (n-- != 0) {

            c1 = text.charAt(textOffset + i);
            c2 = prefix.charAt(prefixOffset + i);

            if (c1 != c2) {

                if (caseSensitive) {
                    return false;
                }

                c1 = Character.toUpperCase(c1);
                c2 = Character.toUpperCase(c2);

                if (c1 != c2) {

                    // We check both upper and lower case because that is how String#equalsIgnoreCase() is defined.
                    // See String#regionMatches(boolean,int,String,int,int)
                    if (Character.toLowerCase(c1) != Character.toLowerCase(c2)) {
                        return false;
                    }

                }

            }

            i++;

        }

        return true;

    }









    static boolean endsWith(final boolean caseSensitive, final String text, final String suffix) {

        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null");
        }
        if (suffix == null) {
            throw new IllegalArgumentException("Suffix cannot be null");
        }

        return (caseSensitive? text.endsWith(suffix) : endsWith(caseSensitive, text, 0, text.length(), suffix, 0, suffix.length()));

    }


    static boolean endsWith(final boolean caseSensitive, final String text, final char[] suffix) {
        return endsWith(caseSensitive, text, 0, text.length(), suffix, 0, suffix.length);
    }

    static boolean endsWith(final boolean caseSensitive, final char[] text, final char[] suffix) {
        return endsWith(caseSensitive, text, 0, text.length, suffix, 0, suffix.length);
    }



    static boolean endsWith(
            final boolean caseSensitive,
            final char[] text, final int textOffset, final int textLen,
            final char[] suffix, final int suffixOffset, final int suffixLen) {

        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null");
        }
        if (suffix == null) {
            throw new IllegalArgumentException("Suffix cannot be null");
        }

        if (textLen < suffixLen) {
            return false;
        }

        final int textReverseOffset = textOffset + textLen - 1;
        final int suffixReverseOffset = suffixOffset + suffixLen - 1;

        char c1, c2;

        int n = suffixLen;
        int i = 0;

        while (n-- != 0) {

            c1 = text[textReverseOffset - i];
            c2 = suffix[suffixReverseOffset - i];

            if (c1 != c2) {

                if (caseSensitive) {
                    return false;
                }

                c1 = Character.toUpperCase(c1);
                c2 = Character.toUpperCase(c2);

                if (c1 != c2) {

                    // We check both upper and lower case because that is how String#equalsIgnoreCase() is defined.
                    // See String#regionMatches(boolean,int,String,int,int)
                    if (Character.toLowerCase(c1) != Character.toLowerCase(c2)) {
                        return false;
                    }

                }

            }

            i++;

        }

        return true;

    }



    static boolean endsWith(
            final boolean caseSensitive,
            final String text, final int textOffset, final int textLen,
            final char[] suffix, final int suffixOffset, final int suffixLen) {

        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null");
        }
        if (suffix == null) {
            throw new IllegalArgumentException("Suffix cannot be null");
        }

        if (textLen < suffixLen) {
            return false;
        }

        final int textReverseOffset = textOffset + textLen - 1;
        final int suffixReverseOffset = suffixOffset + suffixLen - 1;

        char c1, c2;

        int n = suffixLen;
        int i = 0;

        while (n-- != 0) {

            c1 = text.charAt(textReverseOffset - i);
            c2 = suffix[suffixReverseOffset - i];

            if (c1 != c2) {

                if (caseSensitive) {
                    return false;
                }

                c1 = Character.toUpperCase(c1);
                c2 = Character.toUpperCase(c2);

                if (c1 != c2) {

                    // We check both upper and lower case because that is how String#equalsIgnoreCase() is defined.
                    // See String#regionMatches(boolean,int,String,int,int)
                    if (Character.toLowerCase(c1) != Character.toLowerCase(c2)) {
                        return false;
                    }

                }

            }

            i++;

        }

        return true;

    }



    static boolean endsWith(
            final boolean caseSensitive,
            final char[] text, final int textOffset, final int textLen,
            final String suffix, final int suffixOffset, final int suffixLen) {

        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null");
        }
        if (suffix == null) {
            throw new IllegalArgumentException("Suffix cannot be null");
        }

        if (textLen < suffixLen) {
            return false;
        }

        final int textReverseOffset = textOffset + textLen - 1;
        final int suffixReverseOffset = suffixOffset + suffixLen - 1;

        char c1, c2;

        int n = suffixLen;
        int i = 0;

        while (n-- != 0) {

            c1 = text[textReverseOffset - i];
            c2 = suffix.charAt(suffixReverseOffset - i);

            if (c1 != c2) {

                if (caseSensitive) {
                    return false;
                }

                c1 = Character.toUpperCase(c1);
                c2 = Character.toUpperCase(c2);

                if (c1 != c2) {

                    // We check both upper and lower case because that is how String#equalsIgnoreCase() is defined.
                    // See String#regionMatches(boolean,int,String,int,int)
                    if (Character.toLowerCase(c1) != Character.toLowerCase(c2)) {
                        return false;
                    }

                }

            }

            i++;

        }

        return true;

    }



    static boolean endsWith(
            final boolean caseSensitive,
            final String text, final int textOffset, final int textLen,
            final String suffix, final int suffixOffset, final int suffixLen) {

        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null");
        }
        if (suffix == null) {
            throw new IllegalArgumentException("Suffix cannot be null");
        }

        if (textLen < suffixLen) {
            return false;
        }

        final int textReverseOffset = textOffset + textLen - 1;
        final int suffixReverseOffset = suffixOffset + suffixLen - 1;

        char c1, c2;

        int n = suffixLen;
        int i = 0;

        while (n-- != 0) {

            c1 = text.charAt(textReverseOffset - i);
            c2 = suffix.charAt(suffixReverseOffset - i);

            if (c1 != c2) {

                if (caseSensitive) {
                    return false;
                }

                c1 = Character.toUpperCase(c1);
                c2 = Character.toUpperCase(c2);

                if (c1 != c2) {

                    // We check both upper and lower case because that is how String#equalsIgnoreCase() is defined.
                    // See String#regionMatches(boolean,int,String,int,int)
                    if (Character.toLowerCase(c1) != Character.toLowerCase(c2)) {
                        return false;
                    }

                }

            }

            i++;

        }

        return true;

    }









    static boolean contains(final boolean caseSensitive, final String text, final String fragment) {

        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null");
        }
        if (fragment == null) {
            throw new IllegalArgumentException("Fragment cannot be null");
        }

        return (caseSensitive? text.contains(fragment) : contains(caseSensitive, text, 0, text.length(), fragment, 0, fragment.length()));

    }


    static boolean contains(final boolean caseSensitive, final String text, final char[] fragment) {
        return contains(caseSensitive, text, 0, text.length(), fragment, 0, fragment.length);
    }

    static boolean contains(final boolean caseSensitive, final char[] text, final char[] fragment) {
        return contains(caseSensitive, text, 0, text.length, fragment, 0, fragment.length);
    }



    static boolean contains(
            final boolean caseSensitive,
            final char[] text, final int textOffset, final int textLen,
            final char[] fragment, final int fragmentOffset, final int fragmentLen) {

        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null");
        }
        if (fragment == null) {
            throw new IllegalArgumentException("Fragment cannot be null");
        }

        if (textLen < fragmentLen) {
            return false;
        }
        if (fragmentLen == 0) {
            return true;
        }

        char c1, c2;

        for (int i = 0,j = 0; i < textLen; i++) {

            c1 = text[textOffset + i];
            c2 = fragment[fragmentOffset + j];

            if (c1 == c2) {
                if (++j == fragmentLen) {
                    return true;
                }
                continue;
            }

            if (!caseSensitive) {

                c1 = Character.toUpperCase(c1);
                c2 = Character.toUpperCase(c2);
                if (c1 == c2) {
                    if (++j == fragmentLen) {
                        return true;
                    }
                    continue;
                }

                // We check both upper and lower case because that is how String#equalsIgnoreCase() is defined.
                // See String#regionMatches(boolean,int,String,int,int)
                if (Character.toLowerCase(c1) == Character.toLowerCase(c2)) {
                    if (++j == fragmentLen) {
                        return true;
                    }
                    continue;
                }

            }

            j = 0;

        }

        return false;

    }



    static boolean contains(
            final boolean caseSensitive,
            final String text, final int textOffset, final int textLen,
            final char[] fragment, final int fragmentOffset, final int fragmentLen) {

        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null");
        }
        if (fragment == null) {
            throw new IllegalArgumentException("Fragment cannot be null");
        }

        if (textLen < fragmentLen) {
            return false;
        }
        if (fragmentLen == 0) {
            return true;
        }

        char c1, c2;

        for (int i = 0,j = 0; i < textLen; i++) {

            c1 = text.charAt(textOffset + i);
            c2 = fragment[fragmentOffset + j];

            if (c1 == c2) {
                if (++j == fragmentLen) {
                    return true;
                }
                continue;
            }

            if (!caseSensitive) {

                c1 = Character.toUpperCase(c1);
                c2 = Character.toUpperCase(c2);
                if (c1 == c2) {
                    if (++j == fragmentLen) {
                        return true;
                    }
                    continue;
                }

                // We check both upper and lower case because that is how String#equalsIgnoreCase() is defined.
                // See String#regionMatches(boolean,int,String,int,int)
                if (Character.toLowerCase(c1) == Character.toLowerCase(c2)) {
                    if (++j == fragmentLen) {
                        return true;
                    }
                    continue;
                }

            }

            j = 0;

        }

        return false;

    }



    static boolean contains(
            final boolean caseSensitive,
            final char[] text, final int textOffset, final int textLen,
            final String fragment, final int fragmentOffset, final int fragmentLen) {

        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null");
        }
        if (fragment == null) {
            throw new IllegalArgumentException("Fragment cannot be null");
        }

        if (textLen < fragmentLen) {
            return false;
        }
        if (fragmentLen == 0) {
            return true;
        }

        char c1, c2;

        for (int i = 0,j = 0; i < textLen; i++) {

            c1 = text[textOffset + i];
            c2 = fragment.charAt(fragmentOffset + j);

            if (c1 == c2) {
                if (++j == fragmentLen) {
                    return true;
                }
                continue;
            }

            if (!caseSensitive) {

                c1 = Character.toUpperCase(c1);
                c2 = Character.toUpperCase(c2);
                if (c1 == c2) {
                    if (++j == fragmentLen) {
                        return true;
                    }
                    continue;
                }

                // We check both upper and lower case because that is how String#equalsIgnoreCase() is defined.
                // See String#regionMatches(boolean,int,String,int,int)
                if (Character.toLowerCase(c1) == Character.toLowerCase(c2)) {
                    if (++j == fragmentLen) {
                        return true;
                    }
                    continue;
                }

            }

            j = 0;

        }

        return false;

    }



    static boolean contains(
            final boolean caseSensitive,
            final String text, final int textOffset, final int textLen,
            final String fragment, final int fragmentOffset, final int fragmentLen) {

        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null");
        }
        if (fragment == null) {
            throw new IllegalArgumentException("Fragment cannot be null");
        }

        if (textLen < fragmentLen) {
            return false;
        }
        if (fragmentLen == 0) {
            return true;
        }

        char c1, c2;

        for (int i = 0,j = 0; i < textLen; i++) {

            c1 = text.charAt(textOffset + i);
            c2 = fragment.charAt(fragmentOffset + j);

            if (c1 == c2) {
                if (++j == fragmentLen) {
                    return true;
                }
                continue;
            }

            if (!caseSensitive) {

                c1 = Character.toUpperCase(c1);
                c2 = Character.toUpperCase(c2);
                if (c1 == c2) {
                    if (++j == fragmentLen) {
                        return true;
                    }
                    continue;
                }

                // We check both upper and lower case because that is how String#equalsIgnoreCase() is defined.
                // See String#regionMatches(boolean,int,String,int,int)
                if (Character.toLowerCase(c1) == Character.toLowerCase(c2)) {
                    if (++j == fragmentLen) {
                        return true;
                    }
                    continue;
                }

            }

            j = 0;

        }

        return false;

    }









    static int compareTo(final boolean caseSensitive, final String text1, final String text2) {

        if (text1 == null) {
            throw new IllegalArgumentException("First text being compared cannot be null");
        }
        if (text2 == null) {
            throw new IllegalArgumentException("Second text being compared cannot be null");
        }

        return (caseSensitive? text1.compareTo(text2) : text1.compareToIgnoreCase(text2));

    }


    static int compareTo(final boolean caseSensitive, final String text1, final char[] text2) {
        return compareTo(caseSensitive, text1, 0, text1.length(), text2, 0, text2.length);
    }

    static int compareTo(final boolean caseSensitive, final char[] text1, final char[] text2) {
        return compareTo(caseSensitive, text1, 0, text1.length, text2, 0, text2.length);
    }



    static int compareTo(
            final boolean caseSensitive,
            final char[] text1, final int text1Offset, final int text1Len,
            final char[] text2, final int text2Offset, final int text2Len) {

        if (text1 == null) {
            throw new IllegalArgumentException("First text buffer being compared cannot be null");
        }
        if (text2 == null) {
            throw new IllegalArgumentException("Second text buffer being compared cannot be null");
        }

        if (text1 == text2 && text1Offset == text2Offset && text1Len == text2Len) {
            return 0;
        }

        char c1, c2;

        int n = Math.min(text1Len, text2Len);
        int i = 0;

        while (n-- != 0) {

            c1 = text1[text1Offset + i];
            c2 = text2[text2Offset + i];

            if (c1 != c2) {

                if (caseSensitive) {
                    return c1 - c2;
                }

                c1 = Character.toUpperCase(c1);
                c2 = Character.toUpperCase(c2);

                if (c1 != c2) {
                    // We check both upper and lower case because that is how String#compareToIgnoreCase() is defined.
                    c1 = Character.toLowerCase(c1);
                    c2 = Character.toLowerCase(c2);
                    if (c1 != c2) {
                        return c1 - c2;
                    }

                }

            }

            i++;

        }

        return text1Len - text2Len;

    }



    static int compareTo(
            final boolean caseSensitive,
            final String text1, final int text1Offset, final int text1Len,
            final char[] text2, final int text2Offset, final int text2Len) {

        if (text1 == null) {
            throw new IllegalArgumentException("First text being compared cannot be null");
        }
        if (text2 == null) {
            throw new IllegalArgumentException("Second text buffer being compared cannot be null");
        }

        char c1, c2;

        int n = Math.min(text1Len, text2Len);
        int i = 0;

        while (n-- != 0) {

            c1 = text1.charAt(text1Offset + i);
            c2 = text2[text2Offset + i];

            if (c1 != c2) {

                if (caseSensitive) {
                    return c1 - c2;
                }

                c1 = Character.toUpperCase(c1);
                c2 = Character.toUpperCase(c2);

                if (c1 != c2) {
                    // We check both upper and lower case because that is how String#compareToIgnoreCase() is defined.
                    c1 = Character.toLowerCase(c1);
                    c2 = Character.toLowerCase(c2);
                    if (c1 != c2) {
                        return c1 - c2;
                    }

                }

            }

            i++;

        }

        return text1Len - text2Len;

    }




    static int compareTo(
            final boolean caseSensitive,
            final String text1, final int text1Offset, final int text1Len,
            final String text2, final int text2Offset, final int text2Len) {

        if (text1 == null) {
            throw new IllegalArgumentException("First text being compared cannot be null");
        }
        if (text2 == null) {
            throw new IllegalArgumentException("Second text being compared cannot be null");
        }

        if (text1 == text2 && text1Offset == text2Offset && text1Len == text2Len) {
            return 0;
        }

        char c1, c2;

        int n = Math.min(text1Len, text2Len);
        int i = 0;

        while (n-- != 0) {

            c1 = text1.charAt(text1Offset + i);
            c2 = text2.charAt(text2Offset + i);

            if (c1 != c2) {

                if (caseSensitive) {
                    return c1 - c2;
                }

                c1 = Character.toUpperCase(c1);
                c2 = Character.toUpperCase(c2);

                if (c1 != c2) {
                    // We check both upper and lower case because that is how String#compareToIgnoreCase() is defined.
                    c1 = Character.toLowerCase(c1);
                    c2 = Character.toLowerCase(c2);
                    if (c1 != c2) {
                        return c1 - c2;
                    }

                }

            }

            i++;

        }

        return text1Len - text2Len;

    }









    static int binarySearchCharArray(
            final boolean caseSensitive, final List<char[]> values, final char[] text, final int offset, final int len) {

        int low = 0;
        int high = values.size() - 1;

        int mid, cmp;
        char[] midVal;

        while (low <= high) {

            mid = (low + high) >>> 1;
            midVal = values.get(mid);

            cmp = TextUtil.compareTo(caseSensitive, midVal, 0, midVal.length, text, offset, len);

            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                // Found!!
                return mid;
            }

        }

        return -(low + 1);  // Not Found!! We return (-(insertion point) - 1), to guarantee all non-founds are < 0

    }




    static int binarySearchCharArray(
            final boolean caseSensitive, final List<char[]> values, final String text, final int offset, final int len) {

        int low = 0;
        int high = values.size() - 1;

        int mid, cmp;
        char[] midVal;

        while (low <= high) {

            mid = (low + high) >>> 1;
            midVal = values.get(mid);

            cmp = TextUtil.compareTo(caseSensitive, text, offset, len, midVal, 0, midVal.length);

            if (cmp > 0) {
                low = mid + 1;
            } else if (cmp < 0) {
                high = mid - 1;
            } else {
                // Found!!
                return mid;
            }

        }

        return -(low + 1);  // Not Found!! We return (-(insertion point) - 1), to guarantee all non-founds are < 0

    }




    static int binarySearchString(
            final boolean caseSensitive, final List<String> values, final char[] text, final int offset, final int len) {

        int low = 0;
        int high = values.size() - 1;

        int mid, cmp;
        String midVal;

        while (low <= high) {

            mid = (low + high) >>> 1;
            midVal = values.get(mid);

            cmp = TextUtil.compareTo(caseSensitive, midVal, 0, midVal.length(), text, offset, len);

            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                // Found!!
                return mid;
            }

        }

        return -(low + 1);  // Not Found!! We return (-(insertion point) - 1), to guarantee all non-founds are < 0

    }




    static int binarySearchString(
            final boolean caseSensitive, final List<String> values, final String text, final int offset, final int len) {

        int low = 0;
        int high = values.size() - 1;

        int mid, cmp;
        String midVal;

        while (low <= high) {

            mid = (low + high) >>> 1;
            midVal = values.get(mid);

            cmp = TextUtil.compareTo(caseSensitive, text, offset, len, midVal, 0, midVal.length());

            if (cmp > 0) {
                low = mid + 1;
            } else if (cmp < 0) {
                high = mid - 1;
            } else {
                // Found!!
                return mid;
            }

        }

        return -(low + 1);  // Not Found!! We return (-(insertion point) - 1), to guarantee all non-founds are < 0

    }




    static int binarySearchCharArray(
            final boolean caseSensitive, final char[][] values, final char[] text, final int offset, final int len) {

        int low = 0;
        int high = values.length - 1;

        int mid, cmp;
        char[] midVal;

        while (low <= high) {

            mid = (low + high) >>> 1;
            midVal = values[mid];

            cmp = TextUtil.compareTo(caseSensitive, midVal, 0, midVal.length, text, offset, len);

            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                // Found!!
                return mid;
            }

        }

        return -(low + 1);  // Not Found!! We return (-(insertion point) - 1), to guarantee all non-founds are < 0

    }




    static int binarySearchCharArray(
            final boolean caseSensitive, final char[][] values, final String text, final int offset, final int len) {

        int low = 0;
        int high = values.length - 1;

        int mid, cmp;
        char[] midVal;

        while (low <= high) {

            mid = (low + high) >>> 1;
            midVal = values[mid];

            cmp = TextUtil.compareTo(caseSensitive, text, offset, len, midVal, 0, midVal.length);

            if (cmp > 0) {
                low = mid + 1;
            } else if (cmp < 0) {
                high = mid - 1;
            } else {
                // Found!!
                return mid;
            }

        }

        return -(low + 1);  // Not Found!! We return (-(insertion point) - 1), to guarantee all non-founds are < 0

    }




    static int binarySearchString(
            final boolean caseSensitive, final String[] values, final char[] text, final int offset, final int len) {

        int low = 0;
        int high = values.length - 1;

        int mid, cmp;
        String midVal;

        while (low <= high) {

            mid = (low + high) >>> 1;
            midVal = values[mid];

            cmp = TextUtil.compareTo(caseSensitive, midVal, 0, midVal.length(), text, offset, len);

            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                // Found!!
                return mid;
            }

        }

        return -(low + 1);  // Not Found!! We return (-(insertion point) - 1), to guarantee all non-founds are < 0

    }




    static int binarySearchString(
            final boolean caseSensitive, final String[] values, final String text, final int offset, final int len) {

        int low = 0;
        int high = values.length - 1;

        int mid, cmp;
        String midVal;

        while (low <= high) {

            mid = (low + high) >>> 1;
            midVal = values[mid];

            cmp = TextUtil.compareTo(caseSensitive, text, offset, len, midVal, 0, midVal.length());

            if (cmp > 0) {
                low = mid + 1;
            } else if (cmp < 0) {
                high = mid - 1;
            } else {
                // Found!!
                return mid;
            }

        }

        return -(low + 1);  // Not Found!! We return (-(insertion point) - 1), to guarantee all non-founds are < 0

    }









    static int hashCode(final char[] text, final int offset, final int len) {
        // This basically mimics what the String.hashCode() method does, without the need to
        // convert the char[] into a new String object
        // If the text to compute was already a String, it would be better to directly call
        // its 'hashCode()' method, because Strings cache their hash codes.
        int h = 0;
        int off = offset;
        for (int i = 0; i < len; i++) {
            h = 31*h + text[off++];
        }
        return h;
    }



    private TextUtil() {
        super();
    }

}