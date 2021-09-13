import javax.swing.*;
import java.awt.*;
public class ResearchPanel extends JPanel{
    public ResearchPanel(){
        this.setPreferredSize(new Dimension(1050, 694));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel title = new JLabel("Our Research");
        Font titleFont = new Font(title.getName(), Font.BOLD, 30);
        title.setFont(titleFont);
        JLabel questionOne = new JLabel("1. How can the number of COVID-19 cases per state show the trend and transition of the virus as it spreads?");
        Font font = new Font(questionOne.getName(), Font.BOLD, 18);
        Font answerFont = new Font(questionOne.getName(), Font.PLAIN, 14);
        questionOne.setFont(font);
        JLabel answerOne = new JLabel("<html>As seen in our case rankings tab, the first couple cases of COVID-19 did seem to originate in Washington state. Not too long after, cases did begin to appear in California, which could be attributed to the proximity of the two states to one another. At around the same time, there appeared to be a rise in cases in Michigan as well, a state located much farther from Washington state, which could perhaps be explained through domestic travel from state to state. At this point, the number of cases was beginning to rise rapidly on both the western and eastern sides of the country, since domestic travel was still widely used by all before the implementation of quarantine. From that point, the number of confirmed cases in each state continued to rise at practically the same rate. Looking at the most recent data, the most reported cases come from the most densely packed areas (ex. New York, New Jersey). In contrast, the least reported cases come from less populated and more widely spread out localities, such as Alaska or Hawaii.</html>");
       answerOne.setFont(answerFont);
        JLabel questionTwo = new JLabel("2. How has quarantine affected the spread of COVID-19?");
        questionTwo.setFont(font);
        JLabel answerTwo = new JLabel("<html>In most states, quarantine officially began around early March and continues to hold to this date. The data, however, shows an interesting trend, or perhaps a lack of one. As expected before the quarantine was implemented, the number of COVID-19 cases continued to rise steadily. After quarantine, some less populated states, such as Hawaii or Montana, did report a decrease in the spread of COVID-19 cases as shown by their graphs in our program. The intriguing part of this data, however, was that even with the quarantine in place, many populated states still reported the same steady rise in cases. For example, looking at the graph of our data in North Carolina or even Nebraska, the trendline of the graph of cases continues to slope forward at the same consistent rate, perhaps even slightly accelerating in recent days, which could allude to the effectiveness of our isolation.</html>");
        answerTwo.setFont(answerFont);
        JLabel questionThree = new JLabel("3. What are some effective methods to slow down the spread of COVID-19?");
        questionThree.setFont(font);
        JLabel answerThree = new JLabel("<html>Although the data might not support it in a number of cases, social distancing and restricting travel are the most effective ways to make sure that the virus affects the least number of people. Important examples of social distancing include staying at least six feet apart, avoiding group gatherings, staying out of crowded/populated areas, and working directly from home. When shopping or buying essential groceries, make sure to cover the mouth and the nose, preferably with a mask or something similar. Perhaps even order the groceries directly to the house! The reason many of the graphs are still rising at the same rate could be explained by the lack of people actually practicing effective social distancing and continuing to travel, thus spreading the virus and rendering all other attempts to distance meaningless. For example, looking at a state such as Alaska, due to the smaller population and larger land size, it would be very difficult for the virus to spread on its own. Combined with quarantine procedures in place, the graph already shows a plateau as the rate slows down. If this is implemented more strictly in other states, they should show the same flat trend as well, and eventually, it should slope back down.</html>");
        answerThree.setFont(answerFont);
        this.add(title);
        this.add(Box.createRigidArea(new Dimension(0,50)));
        this.add(questionOne);
        this.add(answerOne);
        this.add(Box.createRigidArea(new Dimension(0,50)));
        this.add(questionTwo);
        this.add(answerTwo);
        this.add(Box.createRigidArea(new Dimension(0,50)));
        this.add(questionThree);
        this.add(answerThree);
    }

}
