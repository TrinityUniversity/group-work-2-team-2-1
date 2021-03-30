console.log("here");

const ce = React.createElement;

class showComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = { isVisible: true };
    }

    render() {
        // if (this.state.isVisible) {
        //     return ce('button', {onClick: e =>{
        //         this.setState({isVisible: false});
        //         console.log(this.state.isVisible);
        //     }}, 'Increment'),
        //     ce('p', null, 'The number is currently:'),
        //     ce('span', {id: "counter2"}, this.state.isVisible);
        // }else{
        //     return ce('p', null, 'its gone baby');
        // }
        return ce('h1', null, "Counter");

    }
}

ReactDOM.render(
  ce(showComponent, true),
  document.getElementById('react-root')
);